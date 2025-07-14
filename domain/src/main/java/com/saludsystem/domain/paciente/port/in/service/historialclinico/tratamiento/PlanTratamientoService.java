package com.saludsystem.domain.paciente.port.in.service.historialclinico.tratamiento;

import com.saludsystem.domain.catalogo.model.TipoCitado;
import com.saludsystem.domain.paciente.model.historialclinico.tratamiento.PlanTratamiento;

import java.util.List;
import java.util.UUID;

public interface PlanTratamientoService {
    PlanTratamiento save(PlanTratamiento planTratamiento);
    PlanTratamiento update(UUID uuid, PlanTratamiento planTratamiento);
    void delete(UUID uuid);
    PlanTratamiento getById(UUID uuid);
    List<PlanTratamiento> getAll(UUID hospitalId, int page, int rows);
}