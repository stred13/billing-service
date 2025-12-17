package com.lut.billingservice.dto;

import com.lut.billingservice.enums.Placement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceRequestDTO implements Serializable {

    private String serviceName;

    private String costCenter;

    private String legalEntity;

    private Boolean billable;

    private Placement placement;

}
