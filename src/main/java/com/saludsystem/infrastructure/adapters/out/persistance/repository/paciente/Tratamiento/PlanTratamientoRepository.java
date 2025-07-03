package com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.Tratamiento;

import com.saludsystem.domain.model.paciente.Tratamiento.PlanTratamientoEntity;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanTratamientoRepository extends GenericRepository<PlanTratamientoEntity> {

}