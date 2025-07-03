package com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.HistorialClinico;

import com.saludsystem.domain.model.paciente.HistorialClinico.AntecedentesEntity;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AntecedenteRespository extends GenericRepository<AntecedentesEntity> {

}