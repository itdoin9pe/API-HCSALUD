package com.saludsystem.operaciones.infrastructure.adapters.out.persistance;

import com.saludsystem.operaciones.domain.model.ProveedorEntity;
import com.saludsystem.shared.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends GenericRepository<ProveedorEntity> {

}