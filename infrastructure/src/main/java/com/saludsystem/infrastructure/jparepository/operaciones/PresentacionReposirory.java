package com.saludsystem.infrastructure.jparepository.operaciones;

import com.saludsystem.operaciones.domain.model.PresentacionEntity;
import com.saludsystem.shared.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresentacionReposirory extends GenericRepository<PresentacionEntity> {

}