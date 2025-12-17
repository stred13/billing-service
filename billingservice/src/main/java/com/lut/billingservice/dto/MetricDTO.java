package com.lut.billingservice.dto;

import com.lut.billingservice.enums.Placement;
import com.lut.billingservice.enums.Status;
import com.lut.billingservice.model.Consumption;
import jakarta.persistence.*;
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
public class MetricDTO implements Serializable {

    private LocalDateTime collectedTime;

    private Placement placement;

    private Status status;

    private String remark;

    private LocalDateTime updatedAt;

    private List<ConsumptionDTO> consumptions = new ArrayList<>();
}
