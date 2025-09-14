package com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.evolucion;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.evolucion.CambioCondicionEntity;

@Repository
public interface CambioCondicionJpaRepository extends JpaRepository<CambioCondicionEntity, Long>
{
	Page<CambioCondicionEntity> findAllByHospital_HospitalId(UUID hospitalId, Pageable pageable);
}