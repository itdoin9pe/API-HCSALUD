package com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.HistorialClinico;

import com.saludSystem.domain.model.Paciente.HistorialClinico.ConsultaEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends GenericRepository<ConsultaEntity> {

}