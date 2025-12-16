package com.lut.billingservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CalculationMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long methodId;

    @Column
    private String methodName;

    @Column
    private String description;
}
