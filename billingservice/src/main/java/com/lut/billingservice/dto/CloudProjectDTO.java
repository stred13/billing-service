package com.lut.billingservice.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lut.billingservice.enums.Status;
import com.lut.billingservice.model.Organization;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * A DTO for the {@link com.lut.billingservice.model.CloudProject} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CloudProjectDTO implements Serializable {

    private String cloudProjectName;

    private String costCenter;

    private String owner;

    private LocalDateTime createdTime;

    private LocalDateTime deletedTime;

    private Status status;

    private List<OrganizationDTO> organizations;
}
