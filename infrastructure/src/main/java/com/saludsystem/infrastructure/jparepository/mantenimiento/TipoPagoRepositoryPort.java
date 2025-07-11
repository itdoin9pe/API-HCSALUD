package com.saludsystem.infrastructure.jparepository.mantenimiento;

import com.saludsystem.mantenimiento.domain.model.TipoPagoEntity;
import com.saludsystem.shared.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPagoRepositoryPort extends GenericRepository<TipoPagoEntity> {

}