package com.saludsystem.paciente.application.service.historialclinico.tratamiento;

import com.saludsystem.paciente.application.dto.res.historialclinico.tratamiento.PlanTratamientoDTO;
import com.saludsystem.paciente.application.dto.req.historialclinico.tratamiento.CrearPlanTratamientoDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface PlanTratamientoService extends GenericService<
        CrearPlanTratamientoDTO,
        PlanTratamientoDTO,
        UUID> {
}