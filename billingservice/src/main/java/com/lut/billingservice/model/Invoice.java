package com.lut.billingservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceId;

    @Column
    private LocalDate billingMonth;

    @Column
    private LocalDateTime createdTime;

    @OneToMany(mappedBy = "invoice")
    private List<SubscriptionUnit> subscriptionUnits;
}
