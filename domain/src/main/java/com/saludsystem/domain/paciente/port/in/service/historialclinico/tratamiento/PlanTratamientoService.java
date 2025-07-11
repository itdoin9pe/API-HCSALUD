package com.saludsystem.domain.paciente.port.in.service.historialclinico.tratamiento;


import com.saludsystem.application.dto.get.historialclinico.tratamiento.PlanTratamientoDTO;
import com.saludsystem.application.dto.post.historialclinico.tratamiento.CrearPlanTratamientoDTO;
import com.saludsystem.application.dto.put.historialclinico.tratamiento.ActualizarPlanTratamientoDTO;
import com.configuracion.application.services.GenericService;

import java.util.UUID;

public interface PlanTratamientoService extends GenericService<
        PlanTratamientoDTO,
        CrearPlanTratamientoDTO,
        ActualizarPlanTratamientoDTO,
        UUID> {
}