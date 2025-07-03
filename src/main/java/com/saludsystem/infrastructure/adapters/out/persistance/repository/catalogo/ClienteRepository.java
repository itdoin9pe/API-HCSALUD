package com.saludsystem.infrastructure.adapters.out.persistance.repository.catalogo;

import com.saludsystem.domain.model.catalogo.ClienteEntity;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends GenericRepository<ClienteEntity> {

}