package com.saludsystem.infrastructure.jparepository.catalogo;

import com.catalogo.domain.model.ConsentimientoEntity;
import com.configuracion.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsentimientoJpaRepository extends GenericRepository<ConsentimientoEntity> {
}