package com.saludsystem.operaciones.infrastructure.adapters.out.persistance;

import com.saludsystem.operaciones.domain.model.TipoMaterialEntity;
import com.saludsystem.shared.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoMaterialRepository extends GenericRepository<TipoMaterialEntity> {

}