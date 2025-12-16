package com.lut.billingservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long plan_id;

    @Column
    private String plan_name;

    @Column
    private Boolean billable;

    @Column
    private Integer min_usage_period;

    @Column
    private Integer trial_period;

    @ManyToOne
    @JoinColumn
    private Service service;

    @OneToMany(mappedBy = "plan", cascade = CascadeType.ALL)
    private List<Variant> variants;
}
