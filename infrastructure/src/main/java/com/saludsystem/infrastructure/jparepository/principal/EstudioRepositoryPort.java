package com.saludsystem.infrastructure.jparepository.principal;

import com.saludsystem.domain.model.EstudioEntity;
import com.configuracion.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudioRepositoryPort extends GenericRepository<EstudioEntity> {

}