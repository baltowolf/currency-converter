package com.assignment.currency_converter.service.validation;

/**
 * Service for validate input data
 */
public interface ValidationService {
    /**
     * Validate input data
     *
     * @param sourceCurrency source currency code
     * @param targetCurrency target currency code
     * @param monetaryValue  monetary value
     */
    void validate(String sourceCurrency, String targetCurrency, Double monetaryValue);
}
