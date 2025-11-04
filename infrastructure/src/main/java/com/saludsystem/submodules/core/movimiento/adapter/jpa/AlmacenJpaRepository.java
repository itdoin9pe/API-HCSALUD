package com.saludsystem.submodules.core.movimiento.adapter.jpa;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.saludsystem.submodules.core.movimiento.adapter.entity.AlmacenEntity;

public interface AlmacenJpaRepository extends JpaRepository<AlmacenEntity, UUID>
{
	Page<AlmacenEntity> findAllByHospital_HospitalId(UUID hospitalId, Pageable pageable);
}