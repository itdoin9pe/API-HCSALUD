package com.saludsystem.submodules.core.paciente.adapter.jpa.inter.historialclinico;

import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.AntecedentesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AntecedenteJpaRespository extends JpaRepository<AntecedentesEntity, UUID> {

}