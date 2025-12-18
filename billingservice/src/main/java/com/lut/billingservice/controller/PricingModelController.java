package com.lut.billingservice.controller;

import com.lut.billingservice.dto.PlanDTO;
import com.lut.billingservice.dto.PricingModelDTO;
import com.lut.billingservice.dto.ServiceRequestDTO;
import com.lut.billingservice.dto.VariantDTO;
import com.lut.billingservice.model.ServiceModel;
import com.lut.billingservice.service.PricingModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PricingModelController {
    @Autowired
    PricingModelService service;

    /**
     * Onboards a new pricing model by accepting a PricingModelDTO in the request body.
     *
     * @param pricingModelDTO the DTO containing pricing model data
     * @return the saved ServiceModel entity
     */
    @PostMapping("/onboard-pricing-model")
    public ServiceModel onboardPricingModel(@RequestBody PricingModelDTO pricingModelDTO) {
        return service.onboardPricingModel(pricingModelDTO);
    }

    /**
     * Updates a service by its ID with the provided ServiceRequestDTO.
     *
     * @param serviceId         the ID of the service to be updated
     * @param serviceRequestDTO the DTO containing updated service data
     * @return the updated ServiceModel entity
     */
    @PutMapping("/update-service/{serviceId}")
    public ServiceModel updateServiceById(@PathVariable String serviceId, @RequestBody ServiceRequestDTO serviceRequestDTO) {
        return service.updateService(java.util.UUID.fromString(serviceId), serviceRequestDTO);
    }

    /**
     * Retrieves a service by its ID.
     *
     * @param serviceId the ID of the service to be retrieved
     * @return the ServiceModel entity
     */
    @GetMapping("/get-service/{serviceId}")
    public ServiceModel getServiceById(@PathVariable String serviceId) {
        return service.getServiceById(java.util.UUID.fromString(serviceId));
    }

    /**
     * Retrieves all services.
     *
     * @return a list of all ServiceModel entities
     */
    @GetMapping("/get-all-services")
    public List<ServiceModel> getAllServices() {
        return service.getAllServices();
    }

    /**
     * Deletes a service by its ID.
     *
     * @param serviceId the ID of the service to be deleted
     */
    @DeleteMapping("/delete-service/{serviceId}")
    public void deleteServiceById(@PathVariable String serviceId) {
        service.deleteServiceById(java.util.UUID.fromString(serviceId));
    }

    /**
     * Deletes a plan by its ID.
     *
     * @param planId the ID of the plan to be deleted
     */
    @DeleteMapping("/delete-plan/{planId}")
    public void deletePlanById(@PathVariable String planId) {
        service.deletePlanById(java.util.UUID.fromString(planId));
    }

    /**
     * Deletes a variant by its ID.
     *
     * @param variantId the ID of the variant to be deleted
     */
    @DeleteMapping("/delete-variant/{variantId}")
    public void deleteVariantById(@PathVariable String variantId) {
        service.deleteVariantById(java.util.UUID.fromString(variantId));
    }

    /**
     * Retrieves a plan by its ID.
     *
     * @param planId the ID of the plan to be retrieved
     * @return the Plan entity
     */
    @GetMapping("/get-plan/{planId}")
    public Object getPlanById(@PathVariable String planId) {
        return service.getPlanById(java.util.UUID.fromString(planId));
    }

    /**
     * Retrieves a variant by its ID.
     *
     * @param variantId the ID of the variant to be retrieved
     * @return the Variant entity
     */
    @GetMapping("/get-variant/{variantId}")
    public Object getVariantById(@PathVariable String variantId) {
        return service.getVariantById(java.util.UUID.fromString(variantId));
    }

    /**
     * Updates a plan by its ID with the provided PlanDTO.
     *
     * @param planId  the ID of the plan to be updated
     * @param planDTO the DTO containing updated plan data
     * @return the updated Plan entity
     */
    @PutMapping("/update-plan/{planId}")
    public Object updatePlanById(@PathVariable String planId, @RequestBody PlanDTO planDTO) {
        return service.updatePlan(java.util.UUID.fromString(planId), planDTO);
    }

    /**
     * Updates a variant by its ID with the provided VariantDTO.
     *
     * @param variantId  the ID of the variant to be updated
     * @param variantDTO the DTO containing updated variant data
     * @return the updated Variant entity
     */
    @PutMapping("/update-variant/{variantId}")
    public Object updateVariantById(@PathVariable String variantId, @RequestBody VariantDTO variantDTO) {
        return service.updateVariant(java.util.UUID.fromString(variantId), variantDTO);
    }

}
