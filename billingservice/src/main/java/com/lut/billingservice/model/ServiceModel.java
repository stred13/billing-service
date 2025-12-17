package com.lut.billingservice.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lut.billingservice.enums.Placement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String serviceName;

    @Column
    private String costCenter;

    @Column
    private String legalEntity;

    @Column
    private Boolean billable;

    @Column
    @Enumerated(EnumType.STRING)
    private Placement placement;

    @JsonManagedReference
    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Plan> plans = new ArrayList<>();

    public void addPlan(Plan plan) {
        plans.add(plan);
        plan.setService(this);
    }

    public void removePlan(Plan plan) {
        plans.remove(plan);
        plan.setService(null);
    }

    public void addPlans(List<Plan> planList){
        for(Plan plan : planList){
            this.plans.add(plan);
            plan.setService(this);
        }
    }

    public void removePlans(List<Plan> planList){
        for(Plan plan : planList){
            this.plans.remove(plan);
            plan.setService(null);
        }
    }
}
