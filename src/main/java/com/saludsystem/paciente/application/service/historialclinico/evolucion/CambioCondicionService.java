package com.saludsystem.paciente.application.service.historialclinico.evolucion;

import com.saludsystem.paciente.application.dto.res.historialclinico.evolucion.CambioCondicionResponse;
import com.saludsystem.paciente.application.dto.req.historialclinico.evolucion.CambioCondicionRequest;
import com.saludsystem.paciente.application.dto.evolucion.ActualizarCambioCondicionDTO;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface CambioCondicionService {
    ApiResponse saveCambioCondicion(CambioCondicionRequest cambioCondicionRequest);
    CambioCondicionResponse getCambioCondicionById(Long evolucionCambioCondicionId);
    ApiResponse updateCambioCondicion(Long evolucionCambioCondicionId, ActualizarCambioCondicionDTO actualizarCambioCondicionDTO);
    ListResponse<CambioCondicionResponse> getAllCambioCondicion(UUID hospitalId, int page, int rows);
    ApiResponse deleteCambioCondicion(Long evolucionCambioCondicionId);
}