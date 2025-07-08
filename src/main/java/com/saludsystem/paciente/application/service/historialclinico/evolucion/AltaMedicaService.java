package com.saludsystem.paciente.application.service.historialclinico.evolucion;

import com.saludsystem.paciente.application.dto.res.historialclinico.evolucion.AltaMedicaResponse;
import com.saludsystem.paciente.application.dto.req.historialclinico.evolucion.AltaMedicaRequest;
import com.saludsystem.paciente.application.dto.base.evolucion.ActualizarAltaMedicaDTO;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface AltaMedicaService {
    ApiResponse saveAltaMedica(AltaMedicaRequest altaMedicaRequest);
    AltaMedicaResponse getAltaMedicaById(Long evolucionAltaMedicaId);
    ApiResponse updateAltaMedica(Long evolucionAltaMedicaId, ActualizarAltaMedicaDTO actualizarAltaMedicaDTO);
    ListResponse<AltaMedicaResponse> getAllAltaMedica(UUID hospitalId, int page, int rows);
    ApiResponse deleteAltaMedica(Long evolucionAltaMedicaId);
}