package com.saludsystem.infrastructure.jparepository.configuracion;

import com.configuracion.domain.model.TipoDocumentoEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDocumentoRepositoryPort extends GenericRepository<TipoDocumentoEntity> {

}