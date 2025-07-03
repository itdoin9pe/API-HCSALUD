package com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente;

import com.saludsystem.domain.model.paciente.DiagnosticoEntity;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosticoRepository extends GenericRepository<DiagnosticoEntity> {

}