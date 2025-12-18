package com.lut.billingservice.controller;

import com.lut.billingservice.dto.ConsumptionDTO;
import com.lut.billingservice.dto.MeasureDTO;
import com.lut.billingservice.dto.MetricDTO;
import com.lut.billingservice.model.Consumption;
import com.lut.billingservice.model.Measure;
import com.lut.billingservice.model.MetricDocument;
import com.lut.billingservice.service.MetricDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MetricDocumentController {

    @Autowired
    MetricDocumentService metricDocumentService;

    /**
     * Collects metrics by accepting a MetricDTO in the request body.
     *
     * @param metricDTO the DTO containing metric data
     * @return the saved MetricDocument entity
     */
    @PostMapping("/collect-metrics")
    public MetricDocument collectMetrics(@RequestBody MetricDTO metricDTO) {
        return metricDocumentService.collectMetrics(metricDTO);
    }

    /**
     * Retrieves a metric document by its ID.
     *
     * @param id the ID of the metric document to be retrieved
     * @return the MetricDocument entity
     */
    @GetMapping("/metric/{id}")
    public MetricDocument getMetricById(@PathVariable String id) {
        return metricDocumentService.getMetricById(java.util.UUID.fromString(id));
    }

    /**
     * Retrieves a consumption record by its ID.
     *
     * @param id the ID of the consumption record to be retrieved
     * @return the Consumption entity
     */
    @GetMapping("/get-consumption-by-id/{id}")
    public Consumption getConsumptionById(@PathVariable String id) {
        return metricDocumentService.getConsumptionById(java.util.UUID.fromString(id));
    }

    /**
     * Retrieves a measure record by its ID.
     *
     * @param id the ID of the measure record to be retrieved
     * @return the Measure entity
     */
    @GetMapping("/get-measure-by-id/{id}")
    public Measure getMeasureById(@PathVariable String id) {
        return metricDocumentService.getMeasureById(java.util.UUID.fromString(id));
    }

    /**
     * Updates an existing metric document by its ID using the provided MetricDTO.
     *
     * @param id        the ID of the metric document to be updated
     * @param metricDTO the DTO containing updated metric data
     * @return the updated MetricDocument entity
     */
    @PutMapping("/update-metric/{id}")
    public MetricDocument updateMetric(@PathVariable String id, @RequestBody MetricDTO metricDTO) {
        return metricDocumentService.updateMetricById(java.util.UUID.fromString(id), metricDTO);
    }

    /**
     * Updates an existing consumption record by its ID using the provided ConsumptionDTO.
     *
     * @param id          the ID of the consumption record to be updated
     * @param consumption the DTO containing updated consumption data
     * @return the updated Consumption entity
     */
    @PutMapping("/update-consumption/{id}")
    public Consumption updateConsumption(@PathVariable String id, @RequestBody ConsumptionDTO consumption) {
        return metricDocumentService.updateConsumptionById(java.util.UUID.fromString(id), consumption);
    }

    /**
     * Updates an existing measure record by its ID using the provided MeasureDTO.
     *
     * @param id         the ID of the measure record to be updated
     * @param measureDTO the DTO containing updated measure data
     * @return the updated Measure entity
     */
    @PutMapping("/update-measure/{id}")
    public Measure updateMeasure(@PathVariable String id, @RequestBody MeasureDTO measureDTO) {
        return metricDocumentService.updateMeasureById(java.util.UUID.fromString(id), measureDTO);
    }

    /**
     * Deletes a metric document by its ID.
     *
     * @param id the ID of the metric document to be deleted
     */
    @DeleteMapping("/delete-metric/{id}")
    public void deleteMetric(@PathVariable String id) {
        metricDocumentService.deleteMetricById(java.util.UUID.fromString(id));
    }

    /**
     * Deletes a consumption record by its ID.
     *
     * @param id the ID of the consumption record to be deleted
     */
    @DeleteMapping("/delete-consumption/{id}")
    public void deleteConsumption(@PathVariable String id) {
        metricDocumentService.deleteConsumptionById(java.util.UUID.fromString(id));
    }

    /**
     * Deletes a measure record by its ID.
     *
     * @param id the ID of the measure record to be deleted
     */
    @DeleteMapping("/delete-measure/{id}")
    public void deleteMeasure(@PathVariable String id) {
        metricDocumentService.deleteMeasureById(java.util.UUID.fromString(id));
    }

    /**
     * Retrieves all metric documents.
     *
     * @return a list of all MetricDocument entities
     */
    @GetMapping("/get-all-metrics")
    public List<MetricDocument> getAllMetrics() {
        return metricDocumentService.getAllMetrics();
    }
}
