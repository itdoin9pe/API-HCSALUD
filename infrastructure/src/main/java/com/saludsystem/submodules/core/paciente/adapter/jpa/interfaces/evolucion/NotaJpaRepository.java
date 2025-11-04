package com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.evolucion;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.evolucion.NotaEntity;

public interface NotaJpaRepository extends JpaRepository<NotaEntity, Long>
{
	Page<NotaEntity> findAllByHospital_HospitalId(UUID hospitalId, Pageable pageable);
}