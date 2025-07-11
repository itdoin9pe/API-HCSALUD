package com.saludsystem.infrastructure.jparepository.catalogo;

import com.saludsystem.catalogo.domain.model.ClienteEntity;
import com.saludsystem.shared.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteJpaRepository extends GenericRepository<ClienteEntity> {

}