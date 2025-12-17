package com.lut.billingservice.model;

import com.lut.billingservice.enums.Placement;
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
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class MetricDocument {
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

    @OneToMany(mappedBy = "metricDocument", cascade = CascadeType.ALL)
    private List<Consumption> consumptions;
}
