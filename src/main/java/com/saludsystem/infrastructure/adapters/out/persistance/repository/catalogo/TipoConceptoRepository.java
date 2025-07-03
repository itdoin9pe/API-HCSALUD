package com.saludsystem.infrastructure.adapters.out.persistance.repository.catalogo;

import com.saludsystem.domain.model.catalogo.TipoConceptoEntity;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoConceptoRepository extends GenericRepository<TipoConceptoEntity> {
}