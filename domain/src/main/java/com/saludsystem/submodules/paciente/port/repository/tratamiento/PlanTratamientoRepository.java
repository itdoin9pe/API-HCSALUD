package com.saludsystem.submodules.paciente.port.repository.tratamiento;

import com.saludsystem.submodules.paciente.model.entity.tratamiento.PlanTratamiento;

import java.util.UUID;

public interface PlanTratamientoRepository {
    PlanTratamiento save(PlanTratamiento planTratamiento);
    PlanTratamiento update(UUID uuid, PlanTratamiento planTratamiento);
    void delete(UUID uuid);
}