package com.saludsystem.infrastructure.adapters.out.persistance.repository.mantenimiento;

import com.saludsystem.domain.model.mantenimiento.CuentaEntity;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends GenericRepository<CuentaEntity> {

}