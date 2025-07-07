package com.saludsystem.paciente.application.service.historialclinico.evolucion;

import com.saludsystem.paciente.application.dto.res.historialclinico.evolucion.AltaMedicaDTO;
import com.saludsystem.paciente.application.dto.req.historialclinico.evolucion.CrearAltaMedicaDTO;
import com.saludsystem.paciente.application.dto.evolucion.ActualizarAltaMedicaDTO;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface AltaMedicaService {
    ApiResponse saveAltaMedica(CrearAltaMedicaDTO crearAltaMedicaDTO);
    AltaMedicaDTO getAltaMedicaById(Long evolucionAltaMedicaId);
    ApiResponse updateAltaMedica(Long evolucionAltaMedicaId, ActualizarAltaMedicaDTO actualizarAltaMedicaDTO);
    ListResponse<AltaMedicaDTO> getAllAltaMedica(UUID hospitalId, int page, int rows);
    ApiResponse deleteAltaMedica(Long evolucionAltaMedicaId);
}