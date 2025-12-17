package com.lut.billingservice.model;

import com.lut.billingservice.enums.Placement;
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
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private LocalDateTime createdTime;

    @Column
    private LocalDateTime terminatedAt;

    @Column
    @Enumerated(EnumType.STRING)
    private Placement placement;

    @Column
    private Integer quantity;

    private String organizationId;

    private String serviceId;

    private String planId;

    @OneToMany(mappedBy = "subscription", cascade = CascadeType.ALL)
    private List<SubscriptionEvent> events;
}
