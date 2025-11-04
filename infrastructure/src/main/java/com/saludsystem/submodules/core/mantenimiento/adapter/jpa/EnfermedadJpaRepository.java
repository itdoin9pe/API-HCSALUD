package com.saludsystem.submodules.core.mantenimiento.adapter.jpa;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saludsystem.submodules.core.mantenimiento.adapter.entity.EnfermedadEntity;

@Repository
public interface EnfermedadJpaRepository extends JpaRepository<EnfermedadEntity, String>
{
	// Filtrado por rol
	// @Query("SELECT d FROM EnfermedadEntity d WHERE d.enfermedadId LIKE :prefix%
	// AND d.hospital.hospitalId = :hospitalId")
	// List<EnfermedadEntity> findByRolePrefixAndHospital(@Param("prefix") String
	// prefix, @Param("hospitalId") UUID hospitalId);

	Page<EnfermedadEntity> findByHospital_HospitalId(UUID hospitalId, Pageable pageable);
}