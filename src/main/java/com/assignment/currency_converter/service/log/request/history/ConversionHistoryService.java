package com.assignment.currency_converter.service.log.request.history;

import com.assignment.currency_converter.model.entity.ConversionHistory;

import java.util.List;

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

    /**
     * Find all conversion history entities
     *
     * @return list of ConversionHistory entities
     */
    List<ConversionHistory> findAll();
}
