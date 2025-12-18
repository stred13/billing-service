package com.lut.billingservice.repository;

import com.lut.billingservice.model.ServiceModel;
import com.lut.billingservice.model.ServiceModelId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for ServiceModel entity.
 */
@Repository
public interface ServiceReporsitory extends JpaRepository<ServiceModel, ServiceModelId> {

    Optional<ServiceModel> findServiceModelById(UUID id);

    void deleteServiceModelById(UUID id);

}
