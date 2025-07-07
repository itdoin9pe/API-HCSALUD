package com.saludsystem.paciente.application.service.historialclinico.evolucion;

import com.saludsystem.paciente.application.dto.res.historialclinico.evolucion.NotaDTO;
import com.saludsystem.paciente.application.dto.req.historialclinico.evolucion.CrearNotaDTO;
import com.saludsystem.paciente.application.dto.evolucion.ActualizarNotaDTO;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface NotaService {
    ApiResponse saveNota(CrearNotaDTO crearNotaDTO);
    NotaDTO getNotaById(Long pacienteEvolucionNotaId);
    ApiResponse updateNota(Long pacienteEvolucionNotaId, ActualizarNotaDTO actualizarNotaDTO);
    ListResponse<NotaDTO> getAllNota(UUID hospitalId, int page, int rows);
    ApiResponse deleteNota(Long pacienteEvolucionNotaId);
}