package com.saludsystem.domain.catalogo.port.out.repository;

import com.saludsystem.catalogo.domain.model.ClienteEntity;
import com.saludsystem.shared.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositoryPort extends GenericRepository<ClienteEntity> {

}