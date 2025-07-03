package com.saludsystem.infrastructure.adapters.out.persistance.repository.mantenimiento;

import com.saludsystem.domain.model.mantenimiento.CajaEntity;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CajaRepository extends GenericRepository<CajaEntity> {
}