package com.lut.billingservice.service;

import com.lut.billingservice.dto.ConsumptionDTO;
import com.lut.billingservice.dto.MeasureDTO;
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
import java.util.List;
import java.util.UUID;

@Service
public class MetricDocumentService {
    @Autowired
    ConsumptionRepository consumptionRepository;
    @Autowired
    MeasureRepository measureService;
    @Autowired
    MetricDocumentReporitory metricReporitory;

    /**
     * Collect metrics and save to database
     *
     * @param metricDTO MetricDTO object
     * @return Saved MetricDocument object
     */
    public MetricDocument collectMetrics(MetricDTO metricDTO) {
        return metricReporitory.save(this.convertDTOtoMetrics(metricDTO));
    }

    /**
     * Get MetricDocument by id
     *
     * @param id UUID of the MetricDocument
     * @return MetricDocument object
     */
    public MetricDocument getMetricById(UUID id) {
        return metricReporitory.findById(id).orElse(null);
    }

    /**
     * Get all MetricDocuments
     *
     * @return List of MetricDocument objects
     */
    public List<MetricDocument> getAllMetrics() {
        return metricReporitory.findAll();
    }

    /**
     * Delete MetricDocument by id
     *
     * @param id UUID of the MetricDocument
     */
    public void deleteMetricById(UUID id) {
        metricReporitory.deleteById(id);
    }

    /**
     * Update MetricDocument by id
     *
     * @param id        UUID of the MetricDocument
     * @param metricDTO MetricDTO object
     * @return Updated MetricDocument object
     */
    public MetricDocument updateMetricById(UUID id, MetricDTO metricDTO) {
        MetricDocument existingMetric = metricReporitory.findById(id).orElseThrow(() -> new RuntimeException("Metric not found"));
        existingMetric.setPlacement(metricDTO.getPlacement());
        existingMetric.setStatus(metricDTO.getStatus());
        existingMetric.setRemark(metricDTO.getRemark());
        existingMetric.setUpdatedAt(metricDTO.getUpdatedAt());
        return metricReporitory.save(existingMetric);
    }

    /**
     * Update Consumption by id
     *
     * @param id             UUID of the Consumption
     * @param consumptionDTO ConsumptionDTO object
     * @return Updated Consumption object
     */
    public Consumption updateConsumptionById(UUID id, ConsumptionDTO consumptionDTO) {
        Consumption existingConsumption = consumptionRepository.findById(id).orElseThrow(() -> new RuntimeException("Consumption not found"));
        existingConsumption.setStatus(consumptionDTO.getStatus());
        existingConsumption.setOrgId(consumptionDTO.getOrgId());
        existingConsumption.setPlanId(consumptionDTO.getPlanId());
        existingConsumption.setServiceId(consumptionDTO.getServiceId());
        existingConsumption.setSubscriptionId(consumptionDTO.getSubscriptionId());
        existingConsumption.setStartConsumption(consumptionDTO.getStartConsumption());
        existingConsumption.setEndConsumption(consumptionDTO.getEndConsumption());
        return consumptionRepository.save(existingConsumption);
    }

    /**
     * Update Measure by id
     *
     * @param id         UUID of the Measure
     * @param measureDTO MeasureDTO object
     * @return Updated Measure object
     */
    public Measure updateMeasureById(UUID id, MeasureDTO measureDTO) {
        Measure existingMeasure = measureService.findById(id).orElseThrow(() -> new RuntimeException("Measure not found"));
        existingMeasure.setQuantity(measureDTO.getQuantity());
        existingMeasure.setStatus(measureDTO.getStatus());
        existingMeasure.setVariantId(measureDTO.getVariantId());
        return measureService.save(existingMeasure);
    }

    /**
     * Get Consumption by id
     *
     * @param id UUID of the Consumption
     * @return Consumption object
     */
    public Consumption getConsumptionById(UUID id) {
        return consumptionRepository.findById(id).orElseThrow(() -> new RuntimeException("Consumption not found"));
    }

    /**
     * Get Measure by id
     *
     * @param id UUID of the Measure
     * @return Measure object
     */
    public Measure getMeasureById(UUID id) {
        return measureService.findById(id).orElseThrow(() -> new RuntimeException("Measure not found"));
    }

    /**
     * Delete Consumption by id
     *
     * @param id UUID of the Consumption
     */
    public void deleteConsumptionById(UUID id) {
        consumptionRepository.deleteById(id);
    }

    /**
     * Delete Measure by id
     *
     * @param id UUID of the Measure
     */
    public void deleteMeasureById(UUID id) {
        measureService.deleteById(id);
    }

    /**
     * Convert MetricDTO to MetricDocument
     *
     * @param metricDTO MetricDTO object
     * @return MetricDocument object
     */
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
