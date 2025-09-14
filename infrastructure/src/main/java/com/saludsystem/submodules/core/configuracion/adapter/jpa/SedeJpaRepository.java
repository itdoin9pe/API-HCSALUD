package com.saludsystem.submodules.core.configuracion.adapter.jpa;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SedeEntity;

public interface SedeJpaRepository extends JpaRepository<SedeEntity, UUID>
{
	Page<SedeEntity> findAllByHospital_HospitalId(UUID hospitalId, Pageable pageable);
}