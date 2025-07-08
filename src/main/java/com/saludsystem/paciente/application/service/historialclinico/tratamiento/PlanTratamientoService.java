package com.saludsystem.paciente.application.service.historialclinico.tratamiento;

import com.saludsystem.paciente.application.dto.res.historialclinico.tratamiento.PlanTratamientoResponse;
import com.saludsystem.paciente.application.dto.req.historialclinico.tratamiento.PlanTratamientoRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface PlanTratamientoService extends GenericService<
        PlanTratamientoRequest,
        PlanTratamientoResponse,
        UUID> {
}