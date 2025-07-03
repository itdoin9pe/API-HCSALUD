package com.saludsystem.infrastructure.adapters.out.persistance.repository.mantenimiento;

import com.saludsystem.domain.model.mantenimiento.TipoGastoEntity;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoGastoRepository extends GenericRepository<TipoGastoEntity> {

}