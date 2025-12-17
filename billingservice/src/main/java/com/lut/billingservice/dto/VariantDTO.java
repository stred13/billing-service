package com.lut.billingservice.dto;

import com.lut.billingservice.enums.CalculationMethod;
import com.lut.billingservice.enums.ChargeType;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VariantDTO {
    @NonNull
    private String variantName;

    @NonNull
    @Schema(allowableValues = {"PAY_PER_USE","MONTHLY_FIXED"})
    private ChargeType chargeType;

    @NonNull
    @Valid
    @Min(value = 0, message = "Price must be non-negative")
    private Double variantPrice;

    @NonNull
    @Min(value = 0, message = "Ratio must be non-negative")
    private Float ratio;

    @NonNull
    @Schema(allowableValues = {"MAX", "MIN", "AVG"})
    private CalculationMethod method;
}
