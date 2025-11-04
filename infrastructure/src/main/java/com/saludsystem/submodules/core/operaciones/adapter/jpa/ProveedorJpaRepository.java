package com.saludsystem.submodules.core.operaciones.adapter.jpa;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saludsystem.submodules.core.operaciones.adapter.entity.ProveedorEntity;

@Repository
public interface ProveedorJpaRepository extends JpaRepository<ProveedorEntity, UUID>
{
	Page<ProveedorEntity> findAllByHospital_HospitalId(UUID hospitalId, Pageable pageable);
}