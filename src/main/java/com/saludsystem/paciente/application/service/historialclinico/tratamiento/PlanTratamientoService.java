package com.saludsystem.paciente.application.service.historialclinico.tratamiento;

import com.saludsystem.paciente.application.dto.get.historialclinico.tratamiento.PlanTratamientoDTO;
import com.saludsystem.paciente.application.dto.post.historialclinico.tratamiento.CrearPlanTratamientoDTO;
import com.saludsystem.paciente.application.dto.put.historialclinico.tratamiento.ActualizarPlanTratamientoDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface PlanTratamientoService extends GenericService<
        PlanTratamientoDTO,
        CrearPlanTratamientoDTO,
        ActualizarPlanTratamientoDTO,
        UUID> {
}