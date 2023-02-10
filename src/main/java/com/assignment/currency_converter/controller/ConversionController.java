package com.assignment.currency_converter.controller;

import com.assignment.currency_converter.service.calculation.CalculationService;
import com.assignment.currency_converter.service.exchange.rate.ExchangeRateService;
import com.assignment.currency_converter.service.log.request.history.ConversionHistoryService;
import com.assignment.currency_converter.service.validation.ValidationService;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Controller for the main requests of the application
 */
@Controller
@RequiredArgsConstructor
@Slf4j
public class ConversionController {

    private static final String MAIN_PAGE = "main";
    private final ExchangeRateService exchangeRateService;
    private final CalculationService calculationService;
    private final ValidationService validationService;
    private final ConversionHistoryService conversionHistoryService;

    /**
     * Localhost get request
     *
     * @param model model
     * @return - Main thymeleaf template
     */
    @GetMapping(path = "/")
    public String index(Model model) {
        initCurrenciesOptions(model);
        return MAIN_PAGE;
    }

    /**
     * Calculate Result Value
     *
     * @param model          model
     * @param sourceCurrency source currency code
     * @param targetCurrency target currency code
     * @param monetaryValue  monetary value
     * @return - Main thymeleaf template
     */
    @PostMapping("/calculate-value")
    public String calculateResultValue(
            Model model,
            @RequestParam @NotNull String sourceCurrency,
            @RequestParam @NotNull String targetCurrency,
            @RequestParam @NotNull @Positive Double monetaryValue) {

        validationService.validate(sourceCurrency, targetCurrency, monetaryValue);

        StopWatch watch = new StopWatch();
        watch.start();
        Map<String, Number> rates = exchangeRateService.getExchangeRates();
        String resultValue =
                calculationService.getFormattedResultValue(
                        rates, sourceCurrency, targetCurrency, monetaryValue);
        watch.stop();
        long calculationTime = watch.getTotalTimeMillis();

        model.addAttribute("resultValue", resultValue);
        model.addAttribute("calculationTime", calculationTime);
        log.info(String.format("CalculationTime in milliseconds: %d", calculationTime));
        initCurrenciesOptions(model);

        conversionHistoryService.saveConversionRequest(sourceCurrency, targetCurrency, monetaryValue);
        return MAIN_PAGE;
    }

    /**
     * Init Currencies Options for select-fields on the main page
     *
     * @param model model
     */
    private void initCurrenciesOptions(Model model) {
        List<String> currencies =
                exchangeRateService.getExchangeRates().keySet().stream()
                        .sorted()
                        .collect(Collectors.toList());
        model.addAttribute("currencies", currencies);
    }
}
