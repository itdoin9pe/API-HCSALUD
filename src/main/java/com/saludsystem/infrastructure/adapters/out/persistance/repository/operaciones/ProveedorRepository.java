package com.saludsystem.infrastructure.adapters.out.persistance.repository.operaciones;

import com.saludsystem.domain.model.operaciones.ProveedorEntity;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends GenericRepository<ProveedorEntity> {

}