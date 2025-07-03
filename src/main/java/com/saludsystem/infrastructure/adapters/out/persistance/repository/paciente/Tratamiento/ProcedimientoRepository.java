package com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.Tratamiento;

import com.saludsystem.domain.model.paciente.Tratamiento.ProcedimientoEntity;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcedimientoRepository extends GenericRepository<ProcedimientoEntity> {

}