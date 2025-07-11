package com.saludsystem.infrastructure.jparepository.operaciones;

import com.saludsystem.operaciones.domain.model.ProveedorEntity;
import com.saludsystem.shared.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepositoryPort extends GenericRepository<ProveedorEntity> {

}