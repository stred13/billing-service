package com.lut.billingservice.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lut.billingservice.enums.Placement;
import com.lut.billingservice.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data

@Entity
/* A class representing a metric document entity in the billing service.
*/
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class MetricDocument implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private LocalDateTime collectedTime;

    @Column
    @Enumerated(EnumType.STRING)
    private Placement placement;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column
    private String remark;

    @Column
    private LocalDateTime updatedAt;

    @JsonManagedReference
    @OneToMany(mappedBy = "metricDocument", cascade = CascadeType.ALL)
    private List<Consumption> consumptions = new ArrayList<>();

    public void addConsumption(Consumption consumption){
        this.consumptions.add(consumption);
        consumption.setMetricDocument(this);
    }

    public void removeConsumption(Consumption consumption){
        this.consumptions.remove(consumption);
        consumption.setMetricDocument(null);
    }

    public void addConsumptions(List<Consumption> consumptionList){
        for(Consumption consumption : consumptionList){
            this.consumptions.add(consumption);
            consumption.setMetricDocument(this);
        }
    }

    public void removeConsumptions(List<Consumption> consumptionList){
        for(Consumption consumption : consumptionList){
            this.consumptions.remove(consumption);
            consumption.setMetricDocument(null);
        }
    }
}
