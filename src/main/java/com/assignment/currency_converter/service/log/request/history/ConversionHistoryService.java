package com.assignment.currency_converter.service.log.request.history;

public interface ConversionHistoryService {
    void saveConversionRequest(String sourceCurrency, String targetCurrency, Double monetaryValue);
}
