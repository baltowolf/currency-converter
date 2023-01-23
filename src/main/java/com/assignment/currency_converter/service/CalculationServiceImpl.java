package com.assignment.currency_converter.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class CalculationServiceImpl implements CalculationService{

    @Override
    public String getFormattedResultValue(Map<String, Number> exchangeRates, String sourceCurrency, String targetCurrency, Double monetaryValue) {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.getDefault());
        Currency currencyInstance = Currency.getInstance(targetCurrency);
        if(currencyInstance != null) {
            currencyFormatter.setCurrency(currencyInstance);
        }
        return currencyFormatter.format(exchangeRates.get(targetCurrency).doubleValue()
                / exchangeRates.get(sourceCurrency).doubleValue()
                * monetaryValue);
    }
}
