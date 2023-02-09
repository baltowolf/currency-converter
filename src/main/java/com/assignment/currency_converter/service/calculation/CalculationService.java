package com.assignment.currency_converter.service.calculation;

import java.util.Map;

/**
 * Service for calculate conversion result
 */
public interface CalculationService {

    /**
     * Get formatted string with calculation result and currency symbol
     */
    String getFormattedResultValue(
            Map<String, Number> exchangeRates,
            String sourceCurrency,
            String targetCurrency,
            Double monetaryValue);
}
