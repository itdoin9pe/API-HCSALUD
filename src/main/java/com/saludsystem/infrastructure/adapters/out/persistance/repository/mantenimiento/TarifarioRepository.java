package com.saludsystem.infrastructure.adapters.out.persistance.repository.mantenimiento;

import com.saludsystem.domain.model.mantenimiento.TarifarioEntity;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarifarioRepository extends GenericRepository<TarifarioEntity> {

}