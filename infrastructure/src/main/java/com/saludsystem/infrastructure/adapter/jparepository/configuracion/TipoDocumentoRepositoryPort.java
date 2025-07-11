package com.saludsystem.infrastructure.adapter.jparepository.configuracion;

import com.configuracion.domain.model.TipoDocumentoEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDocumentoRepositoryPort extends GenericRepository<TipoDocumentoEntity> {

}