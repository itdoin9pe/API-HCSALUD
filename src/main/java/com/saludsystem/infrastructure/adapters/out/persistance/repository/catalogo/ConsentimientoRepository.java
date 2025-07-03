package com.saludsystem.infrastructure.adapters.out.persistance.repository.catalogo;

import com.saludsystem.domain.model.catalogo.ConsentimientoEntity;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsentimientoRepository extends GenericRepository<ConsentimientoEntity> {
}