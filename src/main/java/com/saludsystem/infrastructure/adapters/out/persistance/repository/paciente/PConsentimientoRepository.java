package com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente;

import com.saludsystem.domain.model.paciente.PConsentimientoEntity;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PConsentimientoRepository extends GenericRepository<PConsentimientoEntity> {

}