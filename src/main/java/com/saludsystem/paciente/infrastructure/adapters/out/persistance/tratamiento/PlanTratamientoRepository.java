package com.saludsystem.paciente.infrastructure.adapters.out.persistance.tratamiento;

import com.saludsystem.paciente.domain.model.tratamiento.PlanTratamientoEntity;
import com.saludsystem.shared.infrastructure.adapters.out.persistance.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanTratamientoRepository extends GenericRepository<PlanTratamientoEntity> {

}