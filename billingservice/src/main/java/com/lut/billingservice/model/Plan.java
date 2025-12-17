package com.lut.billingservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String planName;

    @Column
    private Boolean billable;

    @Column
    private Integer minUsagePeriod;

    @Column
    private Integer trialPeriod;

    @JsonBackReference
    @ManyToOne
    private ServiceModel service;

    @JsonManagedReference
    @OneToMany(mappedBy = "plan", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Variant> variants = new ArrayList<>();

    public void addVariant(Variant variant){
        this.variants.add(variant);
        variant.setPlan(this);
    }

    public void removeVariant(Variant variant){
        this.variants.remove(variant);
        variant.setPlan(null);
    }
}
