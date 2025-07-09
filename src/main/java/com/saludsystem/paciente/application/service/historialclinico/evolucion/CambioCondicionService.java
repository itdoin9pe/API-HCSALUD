package com.saludsystem.paciente.application.service.historialclinico.evolucion;

import com.saludsystem.paciente.application.dto.get.historialclinico.evolucion.CambioCondicionDTO;
import com.saludsystem.paciente.application.dto.post.historialclinico.evolucion.CrearCambioCondicionDTO;
import com.saludsystem.paciente.application.dto.put.historialclinico.evolucion.ActualizarCambioCondicionDTO;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface CambioCondicionService {
    ApiResponse saveCambioCondicion(CrearCambioCondicionDTO crearCambioCondicionDTO);
    CambioCondicionDTO getCambioCondicionById(Long evolucionCambioCondicionId);
    ApiResponse updateCambioCondicion(Long evolucionCambioCondicionId, ActualizarCambioCondicionDTO actualizarCambioCondicionDTO);
    ListResponse<CambioCondicionDTO> getAllCambioCondicion(UUID hospitalId, int page, int rows);
    ApiResponse deleteCambioCondicion(Long evolucionCambioCondicionId);
}