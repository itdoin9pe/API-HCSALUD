package com.saludsystem.infrastructure.adapter.jparepository.operaciones;

import com.saludsystem.operaciones.domain.model.CategoriaMatEntity;
import com.saludsystem.shared.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaMatRepositoryPort extends GenericRepository<CategoriaMatEntity> {
}