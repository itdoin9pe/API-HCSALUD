package com.saludsystem.domain.paciente.port.in.service.historialclinico.evolucion;

import com.saludsystem.application.dto.get.historialclinico.evolucion.AltaMedicaDTO;
import com.saludsystem.application.dto.post.historialclinico.evolucion.CrearAltaMedicaDTO;
import com.saludsystem.application.dto.put.historialclinico.evolucion.ActualizarAltaMedicaDTO;
import com.shared.infrastructure.adapters.in.response.ApiResponse;
import com.shared.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface AltaMedicaService {
    ApiResponse saveAltaMedica(CrearAltaMedicaDTO crearAltaMedicaDTO);
    AltaMedicaDTO getAltaMedicaById(Long evolucionAltaMedicaId);
    ApiResponse updateAltaMedica(Long evolucionAltaMedicaId, ActualizarAltaMedicaDTO actualizarAltaMedicaDTO);
    ListResponse<AltaMedicaDTO> getAllAltaMedica(UUID hospitalId, int page, int rows);
    ApiResponse deleteAltaMedica(Long evolucionAltaMedicaId);
}