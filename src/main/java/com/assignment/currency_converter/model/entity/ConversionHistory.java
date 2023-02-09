package com.assignment.currency_converter.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table
public class ConversionHistory {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String sourceCurrency;

    @Column
    private String targetCurrency;

    @Column
    private Double monetaryValue;

    @Column
    private LocalDateTime eventDateTime;
}
