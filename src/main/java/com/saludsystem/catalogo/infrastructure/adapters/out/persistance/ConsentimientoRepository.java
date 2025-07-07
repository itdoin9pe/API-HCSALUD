package com.saludsystem.catalogo.infrastructure.adapters.out.persistance;

import com.saludsystem.catalogo.domain.model.ConsentimientoEntity;
import com.saludsystem.shared.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsentimientoRepository extends GenericRepository<ConsentimientoEntity> {
}