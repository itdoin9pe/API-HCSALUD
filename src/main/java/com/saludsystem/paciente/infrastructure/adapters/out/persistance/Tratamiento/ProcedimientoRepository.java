package com.saludsystem.paciente.infrastructure.adapters.out.persistance.Tratamiento;

import com.saludsystem.paciente.domain.model.Tratamiento.ProcedimientoEntity;
import com.saludsystem.shared.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcedimientoRepository extends GenericRepository<ProcedimientoEntity> {

}