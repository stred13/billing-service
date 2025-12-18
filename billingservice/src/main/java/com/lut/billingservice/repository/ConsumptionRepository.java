package com.lut.billingservice.repository;

import com.lut.billingservice.model.Consumption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository interface for Consumption entity
 */
@Repository
public interface ConsumptionRepository extends JpaRepository<Consumption, UUID> {
}
