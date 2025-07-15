package com.saludsystem.submodules.adapter.jpa.interfaces.paciente.historialclinico;

import com.saludsystem.submodules.adapter.entity.paciente.historialclinico.ConsultaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ConsultaJpaRepository extends JpaRepository<ConsultaEntity, UUID> {

}