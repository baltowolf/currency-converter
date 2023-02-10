package com.assignment.currency_converter.service.exchange.rate;

import com.assignment.currency_converter.config.CachingConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExchangeRateServiceImpl implements ExchangeRateService {

    @Qualifier("exchange-rate-service-rest-template")
    private final RestTemplate exchangeRateServiceRestTemplate;

    /**
     * Get Exchange Rates
     *
     * @return Currency code -> Exchange Rate value. Result saves in cache
     */
    @Override
    @Cacheable(CachingConfig.RATES_CACHE)
    public Map<String, Number> getExchangeRates() {
        try {
            return (Map<String, Number>)
                    Objects.requireNonNull(exchangeRateServiceRestTemplate.getForObject("/latest", Map.class))
                            .get("rates");
        } catch (Exception e) {
            throw new RuntimeException("Can't get rates");
        }
    }
}
