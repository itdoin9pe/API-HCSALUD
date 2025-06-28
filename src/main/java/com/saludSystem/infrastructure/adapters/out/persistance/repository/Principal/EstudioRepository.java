package com.saludSystem.infrastructure.adapters.out.persistance.repository.Principal;

import com.saludSystem.domain.model.Principal.EstudioEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudioRepository extends GenericRepository<EstudioEntity> {

}