package com.assignment.currency_converter.service.validation;

import com.assignment.currency_converter.service.exchange.rate.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class ValidationServiceImpl implements ValidationService {

    private final ExchangeRateService exchangeRateService;

    @Override
    public void validate(String sourceCurrency, String targetCurrency, Double monetaryValue) {
        Set<String> validCurrencies = exchangeRateService.getExchangeRates().keySet();
        if (!(validCurrencies.contains(sourceCurrency)
                && validCurrencies.contains(targetCurrency)
                && monetaryValue <= Double.MAX_VALUE)) {
            String errMessage =
                    String.format(
                            "Input data is not valid: sourceCurrency: %s, targetCurrency: %s, monetaryValue: %f",
                            sourceCurrency, targetCurrency, monetaryValue);
            log.error(errMessage);
            throw new RuntimeException(errMessage);
        }
    }
}
