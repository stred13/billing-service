package com.lut.billingservice.model;

import com.lut.billingservice.enums.Placement;
import jakarta.persistence.*;
import lombok.Data;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column
    private String service_name;

    @Column
    private String service_cost_center;

    @Column
    private String legal_entity;

    @Column
    private Boolean billable;

    @Column
    @Enumerated
    private Placement placement;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private List<Plan> plans;
}
