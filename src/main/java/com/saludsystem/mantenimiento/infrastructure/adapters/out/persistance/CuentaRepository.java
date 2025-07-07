package com.saludsystem.mantenimiento.infrastructure.adapters.out.persistance;

import com.saludsystem.mantenimiento.domain.model.CuentaEntity;
import com.saludsystem.shared.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends GenericRepository<CuentaEntity> {

}