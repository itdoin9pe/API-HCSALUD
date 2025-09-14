package com.saludsystem.submodules.core.configuracion.adapter.jpa;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;

@Repository
public interface SysSaludJpaRepository extends JpaRepository<SysSaludEntity, UUID>
{
	Page<SysSaludEntity> findByHospitalId(UUID hospitalId, Pageable pageable);
}