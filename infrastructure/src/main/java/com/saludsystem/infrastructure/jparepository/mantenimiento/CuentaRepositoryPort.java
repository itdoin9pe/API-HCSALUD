package com.saludsystem.infrastructure.jparepository.mantenimiento;

import com.saludsystem.mantenimiento.domain.model.CuentaEntity;
import com.saludsystem.shared.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepositoryPort extends GenericRepository<CuentaEntity> {

}