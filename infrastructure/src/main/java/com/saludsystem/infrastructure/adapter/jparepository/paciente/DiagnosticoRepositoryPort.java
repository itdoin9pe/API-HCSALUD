package com.saludsystem.infrastructure.adapter.jparepository.paciente;

import com.saludsystem.domain.model.DiagnosticoEntity;
import com.configuracion.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosticoRepositoryPort extends GenericRepository<DiagnosticoEntity> {

}