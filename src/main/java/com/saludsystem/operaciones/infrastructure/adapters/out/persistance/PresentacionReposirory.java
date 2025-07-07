package com.saludsystem.operaciones.infrastructure.adapters.out.persistance;

import com.saludsystem.operaciones.domain.model.PresentacionEntity;
import com.saludsystem.shared.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresentacionReposirory extends GenericRepository<PresentacionEntity> {

}