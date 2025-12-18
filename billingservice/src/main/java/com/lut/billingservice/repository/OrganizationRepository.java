package com.lut.billingservice.repository;

import com.lut.billingservice.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository interface for Organization entity operations.
 */
@Repository
public interface OrganizationRepository extends JpaRepository<Organization, UUID> {
}
