package com.saludsystem.infrastructure.adapter.jparepository.catalogo;

import com.saludsystem.catalogo.domain.model.TipoConceptoEntity;
import com.saludsystem.shared.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoConceptoJpaRepository extends GenericRepository<TipoConceptoEntity> {
}