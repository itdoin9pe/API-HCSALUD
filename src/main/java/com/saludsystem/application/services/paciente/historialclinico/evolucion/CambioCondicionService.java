package com.saludsystem.application.services.paciente.historialclinico.evolucion;

import com.saludsystem.application.dtos.paciente.get.historialclinico.evolucion.CambioCondicionDTO;
import com.saludsystem.application.dtos.paciente.post.historialclinico.evolucion.CrearCambioCondicionDTO;
import com.saludsystem.application.dtos.paciente.put.historialclinico.evolucion.ActualizarCambioCondicionDTO;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface CambioCondicionService {
    ApiResponse saveCambioCondicion(CrearCambioCondicionDTO crearCambioCondicionDTO);
    CambioCondicionDTO getCambioCondicionById(Long evolucionCambioCondicionId);
    ApiResponse updateCambioCondicion(Long evolucionCambioCondicionId, ActualizarCambioCondicionDTO actualizarCambioCondicionDTO);
    ListResponse<CambioCondicionDTO> getAllCambioCondicion(UUID hospitalId, int page, int rows);
    ApiResponse deleteCambioCondicion(Long evolucionCambioCondicionId);
}