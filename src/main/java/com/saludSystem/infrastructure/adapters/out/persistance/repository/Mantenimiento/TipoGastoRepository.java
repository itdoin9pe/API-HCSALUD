package com.saludSystem.infrastructure.adapters.out.persistance.repository.Mantenimiento;

import com.saludSystem.domain.model.Mantenimiento.TipoGastoEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoGastoRepository extends GenericRepository<TipoGastoEntity> {

}