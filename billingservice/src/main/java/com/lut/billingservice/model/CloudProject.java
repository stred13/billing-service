package com.lut.billingservice.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lut.billingservice.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * CloudProject entity
 */

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CloudProject {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String cloudProjectName;

    @Column
    private String costCenter;

    @Column
    private String owner;

    @Column
    private LocalDateTime createdTime;

    @Column
    private LocalDateTime deletedTime;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;

    @JsonManagedReference
    @OneToMany(mappedBy = "cloudProject",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Organization> organizations;

    public void addOrganization(Organization organization) {
        this.organizations.add(organization);
        organization.setCloudProject(this);
    }

    public void removeOrganization(Organization organization) {
        this.organizations.remove(organization);
        organization.setCloudProject(null);
    }
}
