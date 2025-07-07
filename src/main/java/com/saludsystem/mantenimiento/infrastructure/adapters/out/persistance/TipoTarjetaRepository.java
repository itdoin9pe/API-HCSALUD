package com.saludsystem.mantenimiento.infrastructure.adapters.out.persistance;

import com.saludsystem.mantenimiento.domain.model.TipoTarjetaEntity;
import com.saludsystem.shared.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoTarjetaRepository extends GenericRepository<TipoTarjetaEntity> {

}