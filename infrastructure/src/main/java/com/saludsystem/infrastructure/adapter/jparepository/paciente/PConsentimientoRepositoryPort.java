package com.saludsystem.infrastructure.adapter.jparepository.paciente;

import com.saludsystem.domain.model.PConsentimientoEntity;
import com.configuracion.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PConsentimientoRepositoryPort extends GenericRepository<PConsentimientoEntity> {

}