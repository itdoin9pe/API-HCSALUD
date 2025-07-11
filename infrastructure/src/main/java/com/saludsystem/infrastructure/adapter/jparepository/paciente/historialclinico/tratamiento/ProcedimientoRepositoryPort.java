package com.saludsystem.infrastructure.adapter.jparepository.paciente.historialclinico.tratamiento;

import com.saludsystem.domain.model.tratamiento.ProcedimientoEntity;
import com.configuracion.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcedimientoRepositoryPort extends GenericRepository<ProcedimientoEntity> {

}