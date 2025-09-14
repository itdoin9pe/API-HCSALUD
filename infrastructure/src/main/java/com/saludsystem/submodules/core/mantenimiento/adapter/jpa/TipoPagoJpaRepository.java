package com.saludsystem.submodules.core.mantenimiento.adapter.jpa;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saludsystem.submodules.core.mantenimiento.adapter.entity.TipoPagoEntity;

@Repository
public interface TipoPagoJpaRepository extends JpaRepository<TipoPagoEntity, UUID>
{
	Page<TipoPagoEntity> findAllByHospital_HospitalId(UUID hospitalId, Pageable pageable);
}