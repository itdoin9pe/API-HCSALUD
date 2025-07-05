package com.saludsystem.application.services.paciente.historialClinico.tratamiento;

import com.saludsystem.application.dtos.paciente.get.historialclinico.tratamiento.PlanTratamientoDTO;
import com.saludsystem.application.dtos.paciente.post.historialclinico.tratamiento.CrearPlanTratamientoDTO;
import com.saludsystem.application.dtos.paciente.put.historialclinico.tratamiento.ActualizarPlanTratamientoDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface PlanTratamientoService extends GenericService<
        PlanTratamientoDTO,
        UUID,
        CrearPlanTratamientoDTO,
        ActualizarPlanTratamientoDTO> {
}