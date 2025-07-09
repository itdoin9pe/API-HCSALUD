package com.saludsystem.paciente.infrastructure.adapters.out.persistance.estadocuenta;

import com.saludsystem.paciente.domain.model.EstadoCuenta.DetalleMedicamentosEstudiosEntity;
import com.saludsystem.shared.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleMedicamentoEstudioRepository extends GenericRepository<DetalleMedicamentosEstudiosEntity> {

}