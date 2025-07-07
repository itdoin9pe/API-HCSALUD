package com.saludsystem.principal.infrastructure.adapters.out.persistance;

import com.saludsystem.principal.domain.model.EmpresaEntity;
import com.saludsystem.shared.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends GenericRepository<EmpresaEntity> {

}