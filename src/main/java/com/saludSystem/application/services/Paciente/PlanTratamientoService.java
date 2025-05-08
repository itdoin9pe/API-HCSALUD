package com.saludSystem.application.services.Paciente;

import com.saludSystem.application.dtos.Paciente.GET.PlanTratamientoDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearPlanTratamientoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarPlanTratamientoDTO;
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