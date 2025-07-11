package com.saludsystem.infrastructure.jparepository.paciente.historialclinico;

import com.saludsystem.domain.model.historialclinico.AntecedentesEntity;
import com.configuracion.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AntecedenteRespository extends GenericRepository<AntecedentesEntity> {

}