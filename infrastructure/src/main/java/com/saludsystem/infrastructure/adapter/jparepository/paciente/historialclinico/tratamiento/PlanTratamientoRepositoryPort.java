package com.saludsystem.infrastructure.adapter.jparepository.paciente.historialclinico.tratamiento;

import com.saludsystem.domain.model.tratamiento.PlanTratamientoEntity;
import com.configuracion.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanTratamientoRepositoryPort extends GenericRepository<PlanTratamientoEntity> {

}