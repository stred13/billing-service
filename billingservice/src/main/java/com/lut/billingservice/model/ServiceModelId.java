package com.lut.billingservice.model;

import com.lut.billingservice.enums.Placement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

/**
 * Composite key class for Service
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceModelId implements Serializable {
    private UUID id;
    private Placement placement;
}
