package com.saludsystem.domain.catalogo.port.out.repository;

import com.catalogo.domain.model.PlanEntity;
import com.configuracion.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepositoryPort extends GenericRepository<PlanEntity> {

}