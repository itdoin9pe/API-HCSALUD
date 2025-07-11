package com.saludsystem.infrastructure.adapter.jparepository.paciente;

import com.saludsystem.domain.model.MedicamentoRecetadoEntity;
import com.configuracion.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentoRecetadoRepositoryPort extends GenericRepository<MedicamentoRecetadoEntity> {

}