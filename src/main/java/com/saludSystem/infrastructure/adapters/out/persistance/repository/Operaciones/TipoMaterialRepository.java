package com.saludSystem.infrastructure.adapters.out.persistance.repository.Operaciones;

import com.saludSystem.domain.model.Operaciones.TipoMaterialEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoMaterialRepository extends GenericRepository<TipoMaterialEntity> {

}