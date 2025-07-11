package com.saludsystem.domain.catalogo.port.out.repository;

import com.catalogo.domain.model.ConsentimientoEntity;
import com.configuracion.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsentimientoRepositoryPort extends GenericRepository<ConsentimientoEntity> {
}