package com.lut.billingservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

/**
 * A DTO for the {@link com.lut.billingservice.model.Plan} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlanDTO {

    @NonNull
    private String planName;

    private Boolean billable;

    private Integer minUsagePeriod;

    private Integer trialPeriod;

    private List<VariantDTO> variants;
}
