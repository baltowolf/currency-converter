package com.assignment.currency_converter.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

/**
 * Configuration for RESTAPI
 */
@Configuration
public class RestTemplateConfig {

    @Value("${exchange-rate-service-url}")
    private String exchangeRateServiceUrl;

    @Bean(name = "exchange-rate-service-rest-template")
    public RestTemplate exchangeRateServiceRestTemplate(RestTemplateBuilder builder) {
        return builder
                .rootUri(exchangeRateServiceUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString())
                .build();
    }
}
