package com.saludsystem.configuracion.infrastructure.adapters.out.persistance;

import com.saludsystem.configuracion.domain.model.TipoDocumentoEntity;
import com.saludsystem.shared.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDocumentoRepository extends GenericRepository<TipoDocumentoEntity> {

}