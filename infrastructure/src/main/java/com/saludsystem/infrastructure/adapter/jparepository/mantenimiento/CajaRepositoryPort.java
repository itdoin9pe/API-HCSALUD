package com.saludsystem.infrastructure.adapter.jparepository.mantenimiento;

import com.saludsystem.mantenimiento.domain.model.CajaEntity;
import com.saludsystem.shared.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CajaRepositoryPort extends GenericRepository<CajaEntity> {
}