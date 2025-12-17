package com.lut.billingservice.service;

import com.lut.billingservice.dto.MetricDTO;
import com.lut.billingservice.model.Consumption;
import com.lut.billingservice.model.Measure;
import com.lut.billingservice.model.MetricDocument;
import com.lut.billingservice.repository.ConsumptionRepository;
import com.lut.billingservice.repository.MeasureRepository;
import com.lut.billingservice.repository.MetricDocumentReporitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class MetricDocumentService {
    @Autowired
    ConsumptionRepository consumptionRepository;
    @Autowired
    MeasureRepository measureService;
    @Autowired
    MetricDocumentReporitory metricReporitory;

    public MetricDocument collectMetrics(MetricDTO metricDTO) {
        return metricReporitory.save(this.convertDTOtoMetrics(metricDTO));
    }

    public MetricDocument getMetricById(UUID id) {
        return metricReporitory.findById(id).orElse(null);
    }

    public MetricDocument convertDTOtoMetrics(MetricDTO metricDTO) {
        MetricDocument metricDocument = MetricDocument.builder()
                .collectedTime(LocalDateTime.now())
                .placement(metricDTO.getPlacement())
                .status(metricDTO.getStatus())
                .remark(metricDTO.getRemark())
                .updatedAt(metricDTO.getUpdatedAt())
                .consumptions(new ArrayList<>())
                .build();
        metricDTO.getConsumptions().forEach(consumptionDTO -> {
            Consumption consumption = Consumption.builder()
                    .status(consumptionDTO.getStatus())
                    .orgId(consumptionDTO.getOrgId())
                    .planId(consumptionDTO.getPlanId())
                    .serviceId(consumptionDTO.getServiceId())
                    .subscriptionId(consumptionDTO.getSubscriptionId())
                    .startConsumption(consumptionDTO.getStartConsumption())
                    .endConsumption(consumptionDTO.getEndConsumption())
                    .measures(new ArrayList<>())
                    .build();
            consumptionDTO.getMeasures().forEach(measureDTO -> {
                Measure measure = Measure.builder()
                        .quantity(measureDTO.getQuantity())
                        .status(measureDTO.getStatus())
                        .variantId(measureDTO.getVariantId())
                        .build();
                consumption.addMeasure(measure);
            });
            metricDocument.addConsumption(consumption);
        });
        return metricDocument;
    }

}
