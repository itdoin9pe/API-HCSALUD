package com.saludsystem.infrastructure.adapter.jparepository.catalogo;

import com.catalogo.domain.model.MedicamentoEntity;
import com.configuracion.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentoJpaRepository extends GenericRepository<MedicamentoEntity> {
}