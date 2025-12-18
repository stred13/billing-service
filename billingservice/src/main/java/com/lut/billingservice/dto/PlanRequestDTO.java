package com.lut.billingservice.dto;

import lombok.*;

import java.util.List;

/**
 * A DTO for the {@link com.lut.billingservice.model.Plan} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlanRequestDTO {
    @NonNull
    private String planName;

    private Boolean billable;

    private Integer minUsagePeriod;

    private Integer trialPeriod;
}
