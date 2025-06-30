package com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.HistorialClinico;

import com.saludSystem.domain.model.Paciente.HistorialClinico.AntecedentesEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AntecedenteRespository extends GenericRepository<AntecedentesEntity> {

}