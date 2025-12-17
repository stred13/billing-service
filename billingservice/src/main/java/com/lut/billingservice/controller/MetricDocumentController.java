package com.lut.billingservice.controller;

import com.lut.billingservice.dto.MetricDTO;
import com.lut.billingservice.model.MetricDocument;
import com.lut.billingservice.service.MetricDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MetricDocumentController {

    @Autowired
    MetricDocumentService metricDocumentService;

    @PostMapping("/collect-metrics")
    public MetricDocument collectMetrics(@RequestBody MetricDTO metricDTO) {
        return metricDocumentService.collectMetrics(metricDTO);
    }

    @GetMapping("/metric/{id}")
    public MetricDocument getMetricById(@PathVariable String id) {
        return metricDocumentService.getMetricById(java.util.UUID.fromString(id));
    }
}
