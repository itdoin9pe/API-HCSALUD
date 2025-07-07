package com.saludsystem.principal.infrastructure.adapters.out.persistance;

import com.saludsystem.principal.domain.model.EstudioEntity;
import com.saludsystem.shared.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudioRepository extends GenericRepository<EstudioEntity> {

}