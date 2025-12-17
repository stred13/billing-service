package com.lut.billingservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.lut.billingservice.enums.CalculationMethod;
import com.lut.billingservice.enums.ChargeType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Variant {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String variantName;

    @Column
    @Enumerated(EnumType.STRING)
    private ChargeType chargeType;

    @Column
    private Double variantPrice;

    @Column
    private Float ratio;

    @ManyToOne
    @JsonBackReference
    private Plan plan;

    @Enumerated(EnumType.STRING)
    private CalculationMethod method;

    @JsonBackReference
    @ManyToOne
    private MeasurementUnit measurementUnit;
}
