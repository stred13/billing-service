package com.lut.billingservice.repository;

import com.lut.billingservice.model.CloudProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository interface for CloudProject entity
 */
@Repository
public interface CloudProjectRepository extends JpaRepository<CloudProject, UUID> {
}
