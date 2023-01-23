package com.assignment.currency_converter.service;

/**
 * Service for validate input data
 */
public interface ValidationService {
    void validate(String sourceCurrency, String targetCurrency, Double monetaryValue);
}
