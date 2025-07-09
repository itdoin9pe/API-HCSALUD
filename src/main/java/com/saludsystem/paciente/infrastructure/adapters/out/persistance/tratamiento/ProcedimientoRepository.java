package com.saludsystem.paciente.infrastructure.adapters.out.persistance.tratamiento;

import com.saludsystem.paciente.domain.model.tratamiento.ProcedimientoEntity;
import com.saludsystem.shared.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcedimientoRepository extends GenericRepository<ProcedimientoEntity> {

}