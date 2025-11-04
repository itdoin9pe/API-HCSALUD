package com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.interconsulta;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.interconsulta.InterconsultaEntity;

@Repository
public interface InterconsultaJpaRepository extends JpaRepository<InterconsultaEntity, UUID>
{
	Page<InterconsultaEntity> findAllByHospital_HospitalId(UUID hospitalId, Pageable pageable);
}
