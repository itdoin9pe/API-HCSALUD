package com.saludsystem.domain.paciente.port.in.service.historialclinico.evolucion;


import com.saludsystem.application.dto.get.historialclinico.evolucion.EvolucionDTO;
import com.saludsystem.application.dto.post.historialclinico.evolucion.CrearEvolucionDTO;
import com.saludsystem.application.dto.put.historialclinico.evolucion.ActualizarEvolucionDTO;
import com.shared.infrastructure.adapters.in.response.ApiResponse;
import com.shared.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface EvolucionService {
    ApiResponse saveEvolucion(CrearEvolucionDTO crearEvolucionDTO);
    ListResponse<EvolucionDTO> getAllEvolucion(UUID hospitalId, int page, int rows);
    EvolucionDTO getEvolucionById(UUID pacienteEvolucionId);
    ApiResponse updateEvolucion(UUID pacienteEvolucionId, ActualizarEvolucionDTO actualizarEvolucionDTO);
    ApiResponse deleteEvolucion(UUID pacienteEvolucionId);
}