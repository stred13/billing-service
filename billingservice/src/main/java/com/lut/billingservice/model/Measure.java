package com.lut.billingservice.model;

import com.lut.billingservice.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Measure {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID measureId;

    @Column
    private Integer quantity;

    @Column
    private Status status;

    @ManyToOne
    private Variant variant;

    @ManyToOne
    private Consumption consumption;
}
