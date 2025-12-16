package com.lut.billingservice.model;

import com.lut.billingservice.enums.Placement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String serviceId;

    @Column
    private String serviceName;

    @Column
    private String costCenter;

    @Column
    private String legalEntity;

    @Column
    private Boolean billable;

    @Column
    private Placement placement;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private List<Plan> plans;
}
