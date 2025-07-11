package com.saludsystem.domain.catalogo.port.out.repository;

import com.saludsystem.catalogo.domain.model.MedidaEntity;
import com.saludsystem.shared.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedidaRepositoryPort extends GenericRepository<MedidaEntity> {

}