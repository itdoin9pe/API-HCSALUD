package com.saludsystem.infrastructure.jparepository.catalogo;

import com.catalogo.domain.model.EspecialidadEntity;
import com.configuracion.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadJpaRepository extends GenericRepository<EspecialidadEntity> {

}