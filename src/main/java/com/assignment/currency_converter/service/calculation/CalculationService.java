package com.assignment.currency_converter.service.calculation;

import java.util.Map;

/**
 * Service for calculate conversion result
 */
public interface CalculationService {

    /**
     * Get formatted string with calculation result and currency symbol
     *
     * @param exchangeRates  exchange rates map: Currency code -> Exchange Rate value
     * @param sourceCurrency source currency code
     * @param targetCurrency target currency code
     * @param monetaryValue  monetary value
     * @return formatted result value
     */
    String getFormattedResultValue(
            Map<String, Number> exchangeRates,
            String sourceCurrency,
            String targetCurrency,
            Double monetaryValue);
}
