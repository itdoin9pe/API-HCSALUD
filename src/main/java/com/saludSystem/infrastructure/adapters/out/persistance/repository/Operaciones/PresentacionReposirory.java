package com.saludSystem.infrastructure.adapters.out.persistance.repository.Operaciones;

import com.saludSystem.domain.model.Operaciones.PresentacionEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresentacionReposirory extends GenericRepository<PresentacionEntity> {

}