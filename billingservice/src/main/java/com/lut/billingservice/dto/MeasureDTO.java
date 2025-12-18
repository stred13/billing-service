package com.lut.billingservice.dto;

import com.lut.billingservice.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link com.lut.billingservice.model.Measure} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MeasureDTO implements Serializable {

    private Status status;

    private Double quantity;

    private String variantId;
}
