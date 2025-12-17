package com.lut.billingservice.service;

import com.lut.billingservice.dto.PricingModelDTO;
import com.lut.billingservice.dto.ServiceRequestDTO;
import com.lut.billingservice.model.Plan;
import com.lut.billingservice.model.ServiceModel;
import com.lut.billingservice.model.Variant;
import com.lut.billingservice.repository.PlanRepository;
import com.lut.billingservice.repository.ServiceReporsitory;
import com.lut.billingservice.repository.VariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class PricingModelService {

    @Autowired
    private ServiceReporsitory serviceReporsitory;
    @Autowired
    private PlanRepository planRepository;
    @Autowired
    private VariantRepository variantRepository;

    /**
     * Onboards a new pricing model by converting the provided DTO to entity and saving it.
     *
     * @param pricingModelDTO the DTO containing pricing model data
     * @return the saved ServiceModel entity
     */
    public ServiceModel onboardPricingModel(PricingModelDTO pricingModelDTO) {
        return serviceReporsitory.save(this.convertDTOtoServiceEntity(pricingModelDTO));
    }

    /**
     * Deletes a service and its associated plans and variants by service ID.
     *
     * @param serviceId the UUID of the service to be deleted
     */
    public void deleteServiceById(UUID serviceId) {
        serviceReporsitory.deleteById(serviceId);
    }

    /**
     * Deletes a plan by its ID.
     *
     * @param planId the UUID of the plan to be deleted
     */
    public void deletePlanById(UUID planId) {
        planRepository.deleteById(planId);
    }

    /**
     * Deletes a variant by its ID.
     *
     * @param id the UUID of the variant to be deleted
     */
    public void deleteVariantById(UUID id) {
        variantRepository.deleteById(id);
    }

    /**
     * Retrieves a service by its ID.
     *
     * @param serviceId the UUID of the service to be retrieved
     * @return the ServiceModel entity if found, otherwise null
     */
    public ServiceModel getServiceById(UUID serviceId) {
        return serviceReporsitory.findById(serviceId).orElse(null);
    }

    /**
     * Retrieves a plan by its ID.
     *
     * @param planId the UUID of the plan to be retrieved
     * @return the Plan entity if found, otherwise null
     */
    public Plan getPlanById(UUID planId) {
        return planRepository.findById(planId).orElse(null);
    }

    /**
     * Retrieves a variant by its ID.
     *
     * @param id the UUID of the variant to be retrieved
     * @return the Variant entity if found, otherwise null
     */
    public Variant getVariantById(UUID id) {
        return variantRepository.findById(id).orElse(null);
    }

    /**
     * Updates a service's details based on the provided ServiceRequestDTO.
     *
     * @param serviceId         the UUID of the service to be updated
     * @param serviceRequestDTO the DTO containing updated service data
     * @return the updated ServiceModel entity
     */
    public ServiceModel updateService(UUID serviceId,ServiceRequestDTO serviceRequestDTO) {
        ServiceModel serviceModel = serviceReporsitory.findById(serviceId).orElseThrow(() -> new RuntimeException("Service not found"));
        serviceModel.setServiceName(serviceRequestDTO.getServiceName());
        serviceModel.setLegalEntity(serviceRequestDTO.getLegalEntity());
        serviceModel.setCostCenter(serviceRequestDTO.getCostCenter());
        serviceModel.setBillable(serviceRequestDTO.getBillable());
        serviceModel.setPlacement(serviceRequestDTO.getPlacement());
        return serviceReporsitory.save(serviceModel);
    }

    /**
     * Converts PricingModelDTO to ServiceModel entity along with nested Plans and Variants.
     *
     * @param pricingModelDTO the DTO containing pricing model data
     * @return the constructed ServiceModel entity
     */
    public ServiceModel convertDTOtoServiceEntity(PricingModelDTO pricingModelDTO) {

        ServiceModel serviceModel = ServiceModel.builder()
                .serviceName(pricingModelDTO.getServiceName())
                .legalEntity(pricingModelDTO.getLegalEntity())
                .costCenter(pricingModelDTO.getCostCenter())
                .billable(pricingModelDTO.getBillable())
                .placement(pricingModelDTO.getPlacement())
                .plans(new ArrayList<>())
                .build();

        pricingModelDTO.getPlans().forEach(planDTO -> {
            Plan plan= Plan.builder()
                    .planName(planDTO.getPlanName())
                    .billable(planDTO.getBillable())
                    .minUsagePeriod(planDTO.getMinUsagePeriod())
                    .trialPeriod(planDTO.getTrialPeriod())
                    .variants(new ArrayList<>())
                    .build();
            planDTO.getVariants().forEach(variantDTO -> {
                Variant variant= Variant.builder()
                        .variantName(variantDTO.getVariantName())
                        .chargeType(variantDTO.getChargeType())
                        .variantPrice(variantDTO.getVariantPrice())
                        .ratio(variantDTO.getRatio())
                        .method(variantDTO.getMethod())
                        .build();
                plan.addVariant(variant);
            });
            serviceModel.addPlan(plan);

        });

        return serviceModel;
    }
}
