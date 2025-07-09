package com.saludsystem.paciente.infrastructure.adapters.out.persistance.historialclinico;

import com.saludsystem.paciente.domain.model.HistorialClinico.ConsultaEntity;
import com.saludsystem.shared.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends GenericRepository<ConsultaEntity> {

}