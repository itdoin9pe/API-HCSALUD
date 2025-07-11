package com.saludsystem.domain.paciente.port.in.service.historialclinico.evolucion;

import com.saludsystem.application.dto.get.historialclinico.evolucion.NotaDTO;
import com.saludsystem.application.dto.post.historialclinico.evolucion.CrearNotaDTO;
import com.saludsystem.application.dto.put.historialclinico.evolucion.ActualizarNotaDTO;
import com.shared.infrastructure.adapters.in.response.ApiResponse;
import com.shared.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface NotaService {
    ApiResponse saveNota(CrearNotaDTO crearNotaDTO);
    NotaDTO getNotaById(Long pacienteEvolucionNotaId);
    ApiResponse updateNota(Long pacienteEvolucionNotaId, ActualizarNotaDTO actualizarNotaDTO);
    ListResponse<NotaDTO> getAllNota(UUID hospitalId, int page, int rows);
    ApiResponse deleteNota(Long pacienteEvolucionNotaId);
}