package com.lut.billingservice.dto;

import com.lut.billingservice.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConsumptionDTO implements Serializable {

    private Status status;

    private String orgId;

    private String planId;

    private String serviceId;

    private String subscriptionId;

    private LocalDateTime startConsumption;

    private LocalDateTime endConsumption;

    private List<MeasureDTO> measures = new ArrayList<>();
}
