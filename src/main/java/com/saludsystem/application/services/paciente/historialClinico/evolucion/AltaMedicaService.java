package com.saludsystem.application.services.paciente.historialClinico.evolucion;

import com.saludsystem.application.dtos.paciente.get.historialclinico.evolucion.AltaMedicaDTO;
import com.saludsystem.application.dtos.paciente.post.historialclinico.evolucion.CrearAltaMedicaDTO;
import com.saludsystem.application.dtos.paciente.put.historialclinico.evolucion.ActualizarAltaMedicaDTO;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface AltaMedicaService {
    ApiResponse saveAltaMedica(CrearAltaMedicaDTO crearAltaMedicaDTO);
    AltaMedicaDTO getAltaMedicaById(Long evolucionAltaMedicaId);
    ApiResponse updateAltaMedica(Long evolucionAltaMedicaId, ActualizarAltaMedicaDTO actualizarAltaMedicaDTO);
    ListResponse<AltaMedicaDTO> getAllAltaMedica(UUID hospitalId, int page, int rows);
    ApiResponse deleteAltaMedica(Long evolucionAltaMedicaId);
}