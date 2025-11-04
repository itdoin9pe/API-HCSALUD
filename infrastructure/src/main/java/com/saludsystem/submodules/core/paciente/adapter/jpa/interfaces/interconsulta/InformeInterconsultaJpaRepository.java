package com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.interconsulta;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.interconsulta.InformeInterconsultaEntity;

public interface InformeInterconsultaJpaRepository extends JpaRepository<InformeInterconsultaEntity, UUID>
{
	Page<InformeInterconsultaEntity> findAllByHospital_HospitalId(UUID hospitalId, Pageable pageable);
}
