package com.saludSystem.application.services.Paciente.Tratamiento;

import com.saludSystem.application.dtos.Paciente.GET.Tratamiento.CostoTratamientoDTO;
import com.saludSystem.application.dtos.Paciente.POST.Tratamiento.CrearCostoTratamientoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.Tratamiento.ActualizarCostoTratamientoDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface CostoTratamientoService {

    ApiResponse saveCostoTratamiento(CrearCostoTratamientoDTO crearCostoTratamientoDTO);

    ListResponse<CostoTratamientoDTO> getAllCostoTratamiento(UUID hospitalId, int page, int rows);

    ApiResponse updateCostoTratamiento(UUID pacienteCostoTratamientoId, ActualizarCostoTratamientoDTO actualizarCostoTratamientoDTO);

    CostoTratamientoDTO getCostoTratamientoById(UUID pacienteCostoTratamientoId);

    ApiResponse deleteCostoTratamiento(UUID pacienteCostoTratamientoId);

}