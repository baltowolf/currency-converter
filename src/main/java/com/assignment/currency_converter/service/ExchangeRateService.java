package com.assignment.currency_converter.service;

import java.util.Map;

/**
 * Service for work with Exchange Rates
 */
public interface ExchangeRateService {
    /**
     * Get Exchange Rates
     * @return Currency code -> Exchange Rate value
     */
    Map<String, Number> getExchangeRates();
}
