package com.assignment.currency_converter.service.validation;

/**
 * Service for validate input data
 */
public interface ValidationService {
    void validate(String sourceCurrency, String targetCurrency, Double monetaryValue);
}
