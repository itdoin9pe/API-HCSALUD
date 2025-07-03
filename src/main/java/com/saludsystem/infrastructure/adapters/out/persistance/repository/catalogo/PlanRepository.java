package com.saludsystem.infrastructure.adapters.out.persistance.repository.catalogo;

import com.saludsystem.domain.model.catalogo.PlanEntity;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends GenericRepository<PlanEntity> {

}