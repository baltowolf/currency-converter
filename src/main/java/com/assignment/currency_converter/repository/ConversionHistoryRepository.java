package com.assignment.currency_converter.repository;

import com.assignment.currency_converter.model.entity.ConversionHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversionHistoryRepository extends JpaRepository<ConversionHistory, Long> {
}
