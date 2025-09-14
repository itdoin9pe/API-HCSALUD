package com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.historialclinico;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.PacienteAlergiaEntity;

@Repository
public interface PacienteAlergiaJpaRepository extends JpaRepository<PacienteAlergiaEntity, UUID>
{
	Page<PacienteAlergiaEntity> findAllByHospital_HospitalId(UUID hospitalId, Pageable pageable);
}