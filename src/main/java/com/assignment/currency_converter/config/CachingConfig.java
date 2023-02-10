package com.assignment.currency_converter.config;

import com.google.common.cache.CacheBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;

import java.util.concurrent.TimeUnit;

/**
 * Cache configuration
 */
@Configuration
@EnableCaching
public class CachingConfig {

    public static final String RATES_CACHE = "rates";

    @Value("${cache-life-time}")
    private long cacheLifeTime;

    /**
     * Create Concurrent Cache Map
     *
     * @return CacheManager bean
     */
    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager() {
            @NonNull
            @Override
            protected Cache createConcurrentMapCache(@NonNull String name) {
                return new ConcurrentMapCache(
                        name,
                        CacheBuilder.newBuilder()
                                .expireAfterWrite(cacheLifeTime, TimeUnit.MINUTES)
                                .build()
                                .asMap(),
                        true);
            }
        };
    }
}
