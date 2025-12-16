package com.lut.billingservice.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
public class Variant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long variant_id;

    @Column
    private String variant_name;

    @Column
    private String charge_type;

    @Column
    private Integer min_usage_period;

    @Column
    private Double variant_price;

    @Column
    private Double ratio;

    private Integer trial_period;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;

    @ManyToOne
    @JoinColumn(name = "calculation_method") // Maps to FK column
    private CalculationMethod calculation_method;

    @ManyToOne
    @JoinColumn(name = "measurement_unit") // Maps to FK column
    private MeasurementUnit measurement_unit;
}
