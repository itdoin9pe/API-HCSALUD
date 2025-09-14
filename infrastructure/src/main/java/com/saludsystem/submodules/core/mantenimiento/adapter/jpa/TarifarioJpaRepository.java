package com.saludsystem.submodules.core.mantenimiento.adapter.jpa;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saludsystem.submodules.core.mantenimiento.adapter.entity.TarifarioEntity;

@Repository
public interface TarifarioJpaRepository extends JpaRepository<TarifarioEntity, UUID>
{
	Page<TarifarioEntity> findAllByHospital_HospitalId(UUID hospitalId, Pageable pageable);
}