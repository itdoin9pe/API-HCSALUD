package com.saludsystem.application.services.paciente.Tratamiento;

import com.saludsystem.application.dtos.paciente.get.tratamiento.PlanTratamientoDTO;
import com.saludsystem.application.dtos.paciente.post.tratamiento.CrearPlanTratamientoDTO;
import com.saludsystem.application.dtos.paciente.put.tratamiento.ActualizarPlanTratamientoDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface PlanTratamientoService extends GenericService<
        PlanTratamientoDTO,
        UUID,
        CrearPlanTratamientoDTO,
        ActualizarPlanTratamientoDTO> {
}