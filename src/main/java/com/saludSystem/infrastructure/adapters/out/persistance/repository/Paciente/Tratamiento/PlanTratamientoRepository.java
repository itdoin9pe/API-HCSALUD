package com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.Tratamiento;

import com.saludSystem.domain.model.Paciente.Tratamiento.PlanTratamientoEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanTratamientoRepository extends GenericRepository<PlanTratamientoEntity> {

}