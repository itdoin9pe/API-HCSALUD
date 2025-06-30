package com.saludSystem.application.services.Paciente.Evolucion;

import com.saludSystem.application.dtos.Paciente.GET.Evolucion.CambioCondicionDTO;
import com.saludSystem.application.dtos.Paciente.POST.Evolucion.CrearCambioCondicionDTO;
import com.saludSystem.application.dtos.Paciente.PUT.Evolucion.ActualizarCambioCondicionDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface CambioCondicionService {
    ApiResponse saveCambioCondicion(CrearCambioCondicionDTO crearCambioCondicionDTO);
    CambioCondicionDTO getCambioCondicionById(Long evolucionCambioCondicionId);
    ApiResponse updateCambioCondicion(Long evolucionCambioCondicionId, ActualizarCambioCondicionDTO actualizarCambioCondicionDTO);
    ListResponse<CambioCondicionDTO> getAllCambioCondicion(UUID hospitalId, int page, int rows);
    ApiResponse deleteCambioCondicion(Long evolucionCambioCondicionId);
}