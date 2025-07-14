package com.saludsystem.infrastructure.adapter.jparepository.paciente.historialclinico;

import com.saludsystem.infrastructure.adapter.entity.paciente.historialclinico.AntecedentesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AntecedenteJpaRespository extends JpaRepository<AntecedentesEntity, UUID> {

}