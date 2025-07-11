package com.saludsystem.domain.catalogo.port.out.repository;

import com.catalogo.domain.model.EspecialidadEntity;
import com.configuracion.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadRepositoryPort extends GenericRepository<EspecialidadEntity> {

}