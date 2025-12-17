package com.lut.billingservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lut.billingservice.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Consumption implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column
    private String orgId;
    @Column
    private String planId;
    @Column
    private String serviceId;
    @Column
    private String subscriptionId;
    @Column
    private LocalDateTime startConsumption;
    @Column
    private LocalDateTime endConsumption;

    @ManyToOne
    @JsonBackReference
    private MetricDocument metricDocument;

    @JsonManagedReference
    @OneToMany(mappedBy = "consumption", cascade = CascadeType.ALL,orphanRemoval = true)
    @ToString.Exclude
    private List<Measure>  measures = new ArrayList<>();

    public void addMeasure(Measure measure){
        this.measures.add(measure);
        measure.setConsumption(this);
    }

    public void removeMeasure(Measure measure){
        this.measures.remove(measure);
        measure.setConsumption(null);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Consumption that = (Consumption) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
