package com.saludsystem.domain.catalogo.port.out.repository;

import com.saludsystem.catalogo.domain.model.TipoCitadoEntity;
import com.saludsystem.shared.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCitadoRepositoryPort extends GenericRepository<TipoCitadoEntity> {

}
