package com.lut.billingservice.dto;

import lombok.*;

import java.util.List;

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
