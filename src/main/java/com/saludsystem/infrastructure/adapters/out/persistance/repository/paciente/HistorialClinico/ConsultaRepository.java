package com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.HistorialClinico;

import com.saludsystem.domain.model.paciente.HistorialClinico.ConsultaEntity;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends GenericRepository<ConsultaEntity> {

}