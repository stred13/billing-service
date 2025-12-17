package com.lut.billingservice.repository;

import com.lut.billingservice.model.Variant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface VariantRepository extends JpaRepository<Variant, UUID> {
}
