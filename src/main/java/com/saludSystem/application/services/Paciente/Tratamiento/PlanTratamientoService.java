package com.saludSystem.application.services.Paciente.Tratamiento;

import com.saludSystem.application.dtos.Paciente.GET.Tratamiento.PlanTratamientoDTO;
import com.saludSystem.application.dtos.Paciente.POST.Tratamiento.CrearPlanTratamientoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.Tratamiento.ActualizarPlanTratamientoDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import java.util.UUID;

public interface PlanTratamientoService {

    ApiResponse savePlanTratamiento(CrearPlanTratamientoDTO crearPlanTratamientoDTO);

    ApiResponse updatePlanTratamiento(UUID pacientePlanTratamientoId, ActualizarPlanTratamientoDTO actualizarPlanTratamientoDTO);

    ListResponse<PlanTratamientoDTO> getAllPlanTratamiento(UUID hospitalId, int page, int rows);

    PlanTratamientoDTO getPlanTratamientoById(UUID pacientePlanTratamientoId);

    ApiResponse deletePlanTratamiento(UUID pacientePlanTratamientoId);

}