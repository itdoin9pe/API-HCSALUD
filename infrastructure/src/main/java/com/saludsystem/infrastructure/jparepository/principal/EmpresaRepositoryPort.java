package com.saludsystem.infrastructure.jparepository.principal;

import com.saludsystem.domain.model.EmpresaEntity;
import com.configuracion.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepositoryPort extends GenericRepository<EmpresaEntity> {

}