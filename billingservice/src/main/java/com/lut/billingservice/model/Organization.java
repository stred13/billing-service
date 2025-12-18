package com.lut.billingservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.lut.billingservice.enums.Placement;
import com.lut.billingservice.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String orgName;

    @Column
    private LocalDateTime createdTime;

    @Column
    private LocalDateTime deletedTime;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column
    @Enumerated(EnumType.STRING)
    private Placement placement;

    @ManyToOne
    @JsonBackReference
    private CloudProject cloudProject;
}
