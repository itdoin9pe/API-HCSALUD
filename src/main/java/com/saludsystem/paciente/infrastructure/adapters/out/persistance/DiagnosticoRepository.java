package com.saludsystem.paciente.infrastructure.adapters.out.persistance;

import com.saludsystem.paciente.domain.model.DiagnosticoEntity;
import com.saludsystem.shared.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosticoRepository extends GenericRepository<DiagnosticoEntity> {

}