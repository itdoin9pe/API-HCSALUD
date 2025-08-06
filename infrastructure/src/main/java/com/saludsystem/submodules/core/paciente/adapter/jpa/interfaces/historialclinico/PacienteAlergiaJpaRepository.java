package com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.historialclinico;

import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.PacienteAlergiaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PacienteAlergiaJpaRepository extends JpaRepository<PacienteAlergiaEntity, UUID> {

}