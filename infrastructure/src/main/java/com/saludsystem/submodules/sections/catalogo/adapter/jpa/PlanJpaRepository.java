package com.saludsystem.submodules.sections.catalogo.adapter.jpa;

import com.saludsystem.submodules.sections.catalogo.adapter.entity.PlanEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlanJpaRepository extends JpaRepository<PlanEntity, UUID> {
    Page<PlanEntity> findAllByHospital_HospitalId(UUID hospitalId, Pageable pageable);
    long countByHospital_HospitalId(UUID hospitalId);
}