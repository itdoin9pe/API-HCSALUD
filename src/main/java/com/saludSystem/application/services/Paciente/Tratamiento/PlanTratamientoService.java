package com.saludSystem.application.services.Paciente.Tratamiento;

import com.saludSystem.application.dtos.Paciente.GET.Tratamiento.PlanTratamientoDTO;
import com.saludSystem.application.dtos.Paciente.POST.Tratamiento.CrearPlanTratamientoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.Tratamiento.ActualizarPlanTratamientoDTO;
import com.saludSystem.application.services.GenericService;

import java.util.UUID;

public interface PlanTratamientoService extends GenericService<
        PlanTratamientoDTO,
        UUID,
        CrearPlanTratamientoDTO,
        ActualizarPlanTratamientoDTO> {
}