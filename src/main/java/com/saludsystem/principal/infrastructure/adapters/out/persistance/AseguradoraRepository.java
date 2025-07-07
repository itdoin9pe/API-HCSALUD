package com.saludsystem.principal.infrastructure.adapters.out.persistance;

import com.saludsystem.principal.domain.model.AseguradoraEntity;
import com.saludsystem.shared.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AseguradoraRepository extends GenericRepository<AseguradoraEntity> {

}