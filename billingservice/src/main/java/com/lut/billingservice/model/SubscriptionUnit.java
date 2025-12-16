package com.lut.billingservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID subscriptionUnitId;

    @ManyToOne
    private Invoice invoice;

    @Column
    private LocalDate billingMonth;

    @Column
    private Double usageHours;

    @Column
    private Double totalConsumption;

    @Column
    private Double totalPrice;

    @Column
    private String subscriptionId;

    @Column
    private String planId;

    @Column
    private String variantId;

    @Column
    private String orgId;

    @Column
    private String cloudProjectId;

    @Column
    private LocalDateTime consumptionStartDate;

    @Column
    private LocalDateTime consumptionEndDate;
}
