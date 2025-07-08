package com.saludsystem.paciente.application.service.historialclinico.evolucion;

import com.saludsystem.paciente.application.dto.res.historialclinico.evolucion.EvolucionDTO;
import com.saludsystem.paciente.application.dto.req.historialclinico.evolucion.EvolucionRequest;
import com.saludsystem.paciente.application.dto.evolucion.ActualizarEvolucionDTO;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import java.util.UUID;

public interface EvolucionService {
    ApiResponse saveEvolucion(EvolucionRequest evolucionRequest);
    ListResponse<EvolucionDTO> getAllEvolucion(UUID hospitalId, int page, int rows);
    EvolucionDTO getEvolucionById(UUID pacienteEvolucionId);
    ApiResponse updateEvolucion(UUID pacienteEvolucionId, ActualizarEvolucionDTO actualizarEvolucionDTO);
    ApiResponse deleteEvolucion(UUID pacienteEvolucionId);
}