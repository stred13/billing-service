package com.lut.billingservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lut.billingservice.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * The Consumption entity represents the consumption details of a service within a specific plan and organization.
 */
@Entity

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Consumption implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column
    private String orgId;
    @Column
    private String planId;
    @Column
    private String serviceId;
    @Column
    private String subscriptionId;
    @Column
    private LocalDateTime startConsumption;
    @Column
    private LocalDateTime endConsumption;

    @ManyToOne
    @JsonBackReference
    private MetricDocument metricDocument;

    @JsonManagedReference
    @OneToMany(mappedBy = "consumption", cascade = CascadeType.ALL,orphanRemoval = true)
    @ToString.Exclude
    private List<Measure>  measures = new ArrayList<>();

    public void addMeasure(Measure measure){
        this.measures.add(measure);
        measure.setConsumption(this);
    }

    public void removeMeasure(Measure measure){
        this.measures.remove(measure);
        measure.setConsumption(null);
    }
}
