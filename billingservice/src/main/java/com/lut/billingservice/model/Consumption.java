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
    private UUID consumptionId;

    @Column
    private LocalDateTime startTime;

    @Column
    private LocalDateTime endTime;

    @Column
    private Status status;

    @ManyToOne
    private MetricDocument metricDocument;

    // Relationships inferred from ID columns in diagram
    @ManyToOne
    private Organization organization;

    @ManyToOne
    private Service service;

    @ManyToOne
    private Plan plan;

    @ManyToOne
    private Subscription subscription;

    @OneToMany(mappedBy = "consumption", cascade = CascadeType.ALL)
    private List<Measure> measures;
}
