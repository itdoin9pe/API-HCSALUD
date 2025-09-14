package com.saludsystem.submodules.core.catalogo.adapter.jpa;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saludsystem.submodules.core.catalogo.adapter.entity.PlanEntity;

@Repository
public interface PlanJpaRepository extends JpaRepository<PlanEntity, UUID>
{
	Page<PlanEntity> findAllByHospital_HospitalId(UUID hospitalId, Pageable pageable);

	long countByHospital_HospitalId(UUID hospitalId);
}