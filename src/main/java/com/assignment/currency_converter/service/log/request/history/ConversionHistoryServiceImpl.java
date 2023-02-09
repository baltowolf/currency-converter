package com.assignment.currency_converter.service.log.request.history;

import com.assignment.currency_converter.model.entity.ConversionHistory;
import com.assignment.currency_converter.repository.ConversionHistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConversionHistoryServiceImpl implements ConversionHistoryService {

    private final ConversionHistoryRepository conversionHistoryRepository;

    @Override
    @Transactional
    public void saveConversionRequest(String sourceCurrency, String targetCurrency, Double monetaryValue) {
        ConversionHistory conversionHistory = ConversionHistory.builder()
                .sourceCurrency(sourceCurrency)
                .targetCurrency(targetCurrency)
                .monetaryValue(monetaryValue)
                .eventDateTime(LocalDateTime.now())
                .build();
        ConversionHistory savedEntity = conversionHistoryRepository.save(conversionHistory);
        log.info("Conversion Request Entity saved into database: " + savedEntity);
    }
}
