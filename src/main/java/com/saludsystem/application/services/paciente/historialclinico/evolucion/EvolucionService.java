package com.saludsystem.application.services.paciente.historialclinico.evolucion;

import com.saludsystem.application.dtos.paciente.get.historialclinico.evolucion.EvolucionDTO;
import com.saludsystem.application.dtos.paciente.post.historialclinico.evolucion.CrearEvolucionDTO;
import com.saludsystem.application.dtos.paciente.put.historialclinico.evolucion.ActualizarEvolucionDTO;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import java.util.UUID;

public interface EvolucionService {
    ApiResponse saveEvolucion(CrearEvolucionDTO crearEvolucionDTO);
    ListResponse<EvolucionDTO> getAllEvolucion(UUID hospitalId, int page, int rows);
    EvolucionDTO getEvolucionById(UUID pacienteEvolucionId);
    ApiResponse updateEvolucion(UUID pacienteEvolucionId, ActualizarEvolucionDTO actualizarEvolucionDTO);
    ApiResponse deleteEvolucion(UUID pacienteEvolucionId);
}