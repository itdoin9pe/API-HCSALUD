package com.saludsystem.submodules.paciente.port.dao.historialclinico.tratamiento;

import com.saludsystem.submodules.paciente.model.entity.historialclinico.tratamiento.PlanTratamiento;

import java.util.List;
import java.util.UUID;

public interface PlanTratamientoDao {
    PlanTratamiento save(PlanTratamiento planTratamiento);
    PlanTratamiento update(UUID uuid, PlanTratamiento planTratamiento);
    void delete(UUID uuid);
    PlanTratamiento getById(UUID uuid);
    List<PlanTratamiento> getAll(UUID hospitalId, int page, int rows);
}