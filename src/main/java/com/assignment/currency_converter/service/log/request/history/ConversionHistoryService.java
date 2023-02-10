package com.assignment.currency_converter.service.log.request.history;

/**
 * Service to work with Conversion History
 */
public interface ConversionHistoryService {
    /**
     * Save conversion request data into db
     *
     * @param sourceCurrency source currency code
     * @param targetCurrency target currency code
     * @param monetaryValue  monetary value
     */
    void saveConversionRequest(String sourceCurrency, String targetCurrency, Double monetaryValue);
}
