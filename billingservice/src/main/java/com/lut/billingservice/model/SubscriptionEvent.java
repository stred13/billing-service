package com.lut.billingservice.model;

import com.lut.billingservice.enums.EventType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID subscriptionEventId;

    @Column
    private EventType eventType;

    @Column
    private LocalDateTime eventTime;

    @ManyToOne
    private Subscription subscription;
}
