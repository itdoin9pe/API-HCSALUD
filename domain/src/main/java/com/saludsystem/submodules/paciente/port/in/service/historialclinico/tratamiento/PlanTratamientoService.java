package com.saludsystem.submodules.paciente.port.in.service.historialclinico.tratamiento;

import com.saludsystem.submodules.paciente.model.historialclinico.tratamiento.PlanTratamiento;

import java.util.List;
import java.util.UUID;

public interface PlanTratamientoService {
    PlanTratamiento save(PlanTratamiento planTratamiento);
    PlanTratamiento update(UUID uuid, PlanTratamiento planTratamiento);
    void delete(UUID uuid);
    PlanTratamiento getById(UUID uuid);
    List<PlanTratamiento> getAll(UUID hospitalId, int page, int rows);
}