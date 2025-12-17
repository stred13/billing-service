package com.lut.billingservice.model;

import com.lut.billingservice.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Consumption {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;

    private String orgId;

    private String planId;
    private String serviceId;
    private String subscriptionId;

    private LocalDateTime startConsumption;
    private LocalDateTime endConsumption;

    @OneToMany(mappedBy = "consumption")
    private List<Measure>  measures;

    @ManyToOne
    private MetricDocument metricDocument;
}
