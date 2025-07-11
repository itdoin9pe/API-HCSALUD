package com.saludsystem.domain.paciente.port.in.service.historialclinico.evolucion;

import com.saludsystem.application.dto.get.historialclinico.evolucion.CambioCondicionDTO;
import com.saludsystem.application.dto.post.historialclinico.evolucion.CrearCambioCondicionDTO;
import com.saludsystem.application.dto.put.historialclinico.evolucion.ActualizarCambioCondicionDTO;
import com.shared.infrastructure.adapters.in.response.ApiResponse;
import com.shared.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface CambioCondicionService {
    ApiResponse saveCambioCondicion(CrearCambioCondicionDTO crearCambioCondicionDTO);
    CambioCondicionDTO getCambioCondicionById(Long evolucionCambioCondicionId);
    ApiResponse updateCambioCondicion(Long evolucionCambioCondicionId, ActualizarCambioCondicionDTO actualizarCambioCondicionDTO);
    ListResponse<CambioCondicionDTO> getAllCambioCondicion(UUID hospitalId, int page, int rows);
    ApiResponse deleteCambioCondicion(Long evolucionCambioCondicionId);
}