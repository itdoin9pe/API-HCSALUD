package com.saludsystem.catalogo.infrastructure.adapters.out.persistance;

import com.saludsystem.catalogo.domain.model.TipoConceptoEntity;
import com.saludsystem.shared.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoConceptoRepository extends GenericRepository<TipoConceptoEntity> {
}