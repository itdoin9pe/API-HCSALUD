package com.saludsystem.paciente.application.service.historialclinico.evolucion;

import com.saludsystem.paciente.application.dto.res.historialclinico.evolucion.EvolucionResponse;
import com.saludsystem.paciente.application.dto.req.historialclinico.evolucion.EvolucionRequest;
import com.saludsystem.paciente.application.dto.base.evolucion.ActualizarEvolucionDTO;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import java.util.UUID;

public interface EvolucionService {
    ApiResponse saveEvolucion(EvolucionRequest evolucionRequest);
    ListResponse<EvolucionResponse> getAllEvolucion(UUID hospitalId, int page, int rows);
    EvolucionResponse getEvolucionById(UUID pacienteEvolucionId);
    ApiResponse updateEvolucion(UUID pacienteEvolucionId, ActualizarEvolucionDTO actualizarEvolucionDTO);
    ApiResponse deleteEvolucion(UUID pacienteEvolucionId);
}