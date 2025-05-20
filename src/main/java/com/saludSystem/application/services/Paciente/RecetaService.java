package com.saludSystem.application.services.Paciente;

import com.saludSystem.application.dtos.Paciente.GET.RecetaDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearRecetaDTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarRecetaDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface RecetaService {

    ApiResponse saveReceta(CrearRecetaDTO crearRecetaDTO);

    ListResponse<RecetaDTO> getAllReceta(UUID hospitalId, int page, int rows);

    ApiResponse updateReceta(UUID pacienteRecetaId, ActualizarRecetaDTO actualizarRecetaDTO);

    RecetaDTO getRecetaById(UUID pacienteRecetaId);

    ApiResponse deleteReceta(UUID pacienteRecetaId);

}