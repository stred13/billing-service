package com.lut.billingservice.dto;

import com.lut.billingservice.enums.Placement;
import com.lut.billingservice.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.lut.billingservice.model.Organization} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrganizationDTO implements Serializable {

    private String orgName;

    private LocalDateTime createdTime;

    private LocalDateTime deletedTime;

    private Status status;

    private Placement placement;

}
