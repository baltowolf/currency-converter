package com.assignment.currency_converter.service.exchange.rate;

import java.util.Map;

/**
 * Service for work with Exchange Rates
 */
public interface ExchangeRateService {
    /**
     * Get Exchange Rates
     *
     * @return Currency code -> Exchange Rate value. Result saves in cache
     */
    Map<String, Number> getExchangeRates();
}
