package com.saludsystem.infrastructure.adapters.out.persistance.repository.principal;

import com.saludsystem.domain.model.principal.EmpresaEntity;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends GenericRepository<EmpresaEntity> {

}