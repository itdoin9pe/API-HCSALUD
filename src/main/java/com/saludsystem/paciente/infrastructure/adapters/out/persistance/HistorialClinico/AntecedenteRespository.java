package com.saludsystem.paciente.infrastructure.adapters.out.persistance.HistorialClinico;

import com.saludsystem.paciente.domain.model.HistorialClinico.AntecedentesEntity;
import com.saludsystem.shared.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AntecedenteRespository extends GenericRepository<AntecedentesEntity> {

}