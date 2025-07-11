package com.saludsystem.infrastructure.jparepository.paciente.historialclinico.estadocuenta;

import com.saludsystem.domain.model.estadocuenta.DetalleMedicamentosEstudiosEntity;
import com.configuracion.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleMedicamentoEstudioRepositoryPort extends GenericRepository<DetalleMedicamentosEstudiosEntity> {

}