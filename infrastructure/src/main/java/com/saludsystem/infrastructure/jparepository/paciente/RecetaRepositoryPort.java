package com.saludsystem.infrastructure.jparepository.paciente;

import com.saludsystem.domain.model.RecetaEntity;
import com.configuracion.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecetaRepositoryPort extends GenericRepository<RecetaEntity> {

}