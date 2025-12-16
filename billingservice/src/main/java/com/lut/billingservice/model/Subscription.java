package com.lut.billingservice.model;

import com.lut.billingservice.enums.Placement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String subscriptionId;

    @Column
    private LocalDateTime createdTime;

    @Column
    private LocalDateTime terminatedAt;

    @Column
    private Placement placement;

    @Column
    private Integer quantity;

    @ManyToOne
    private Organization organization;

    @ManyToOne
    private Service service;

    @ManyToOne
    private Plan plan;

    @OneToMany(mappedBy = "subscription", cascade = CascadeType.ALL)
    private List<SubscriptionEvent> events;
}
