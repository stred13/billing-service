package com.lut.billingservice.converter;

import com.lut.billingservice.dto.PricingModelDTO;
import com.lut.billingservice.model.ServiceModel;

import java.util.ArrayList;
import java.util.function.Function;

public class ServiceModelConverter extends Converter<PricingModelDTO, ServiceModel> {

    public ServiceModelConverter() {
        super(ServiceModelConverter::converToEntity, ServiceModelConverter::convertToDTO);
    }

    // Convert Entity to DTO
    private static PricingModelDTO convertToDTO(ServiceModel entity) {
        return PricingModelDTO.builder()
                .serviceName(entity.getServiceName())
                .legalEntity(entity.getLegalEntity())
                .costCenter(entity.getCostCenter())
                .billable(entity.getBillable())
                .placement(entity.getPlacement())
                .plans(new ArrayList<>())
                .build();
    }

    // Convert DTO to Entity
    private static ServiceModel converToEntity(PricingModelDTO dto) {
        return  ServiceModel.builder()
                .serviceName(dto.getServiceName())
                .legalEntity(dto.getLegalEntity())
                .costCenter(dto.getCostCenter())
                .billable(dto.getBillable())
                .placement(dto.getPlacement())
                .plans(new ArrayList<>())
                .build();
    }
}
