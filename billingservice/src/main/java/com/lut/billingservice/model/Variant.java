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
public class Variant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String variantId;

    @Column
    private String variantName;

    @Column
    private String chargeType;

    @Column
    private Integer minUsagePeriod;

    @Column
    private Double variantPrice;

    @Column
    private Float ratio;

    @Column
    private Integer trialPeriod;

    @ManyToOne
    private Plan plan;

    @ManyToOne
    private CalculationMethod calculationMethod;

    @ManyToOne
    private MeasurementUnit measurementUnit;
}
