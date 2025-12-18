package com.lut.billingservice.dto;

import com.lut.billingservice.enums.Placement;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link com.lut.billingservice.model.PricingModel} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PricingModelDTO implements Serializable {

    private String serviceName;

    private String costCenter;

    private String legalEntity;

    private Boolean billable;

    private Placement placement;

    private List<PlanDTO> plans;

}
