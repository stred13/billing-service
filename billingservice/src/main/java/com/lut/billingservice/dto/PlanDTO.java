package com.lut.billingservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

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
