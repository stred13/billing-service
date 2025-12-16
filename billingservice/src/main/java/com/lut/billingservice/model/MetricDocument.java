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
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class MetricDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID metricDocumentId;

    @Column
    private LocalDateTime createdTime;

    @Column
    private LocalDateTime collectedTime;

    @Column
    private String placement;

    @Column
    private Status status;

    @Column
    private String remark;

    @Column
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "metricDocument", cascade = CascadeType.ALL)
    private List<Consumption> consumptions;
}
