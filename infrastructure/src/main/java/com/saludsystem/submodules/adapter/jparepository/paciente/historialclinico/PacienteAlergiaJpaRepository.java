package com.saludsystem.submodules.adapter.jparepository.paciente.historialclinico;

import com.saludsystem.submodules.adapter.entity.paciente.historialclinico.PacienteAlergiaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PacienteAlergiaJpaRepository extends JpaRepository<PacienteAlergiaEntity, UUID> {

}