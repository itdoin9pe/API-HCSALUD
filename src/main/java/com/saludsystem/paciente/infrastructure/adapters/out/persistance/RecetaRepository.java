package com.saludsystem.paciente.infrastructure.adapters.out.persistance;

import com.saludsystem.paciente.domain.model.RecetaEntity;
import com.saludsystem.shared.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecetaRepository extends GenericRepository<RecetaEntity> {

}