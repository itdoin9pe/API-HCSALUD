package com.saludsystem.paciente.infrastructure.adapters.out.persistance;

import com.saludsystem.paciente.domain.model.MedicamentoRecetadoEntity;
import com.saludsystem.shared.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentoRecetadoRepository extends GenericRepository<MedicamentoRecetadoEntity> {

}