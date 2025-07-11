package com.saludsystem.infrastructure.adapter.jparepository.catalogo;

import com.saludsystem.catalogo.domain.model.MedidaEntity;
import com.saludsystem.shared.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedidaJpaRepository extends GenericRepository<MedidaEntity> {

}