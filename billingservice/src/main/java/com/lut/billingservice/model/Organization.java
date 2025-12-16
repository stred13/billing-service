package com.lut.billingservice.model;

import com.lut.billingservice.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String orgId;

    @Column
    private String orgName;

    @Column
    private LocalDateTime createdTime;

    @Column
    private LocalDateTime deletedTime;

    @Column
    private Status status;

    @ManyToOne
    private CloudProject cloudProject;

    @Column
    private String region;
}
