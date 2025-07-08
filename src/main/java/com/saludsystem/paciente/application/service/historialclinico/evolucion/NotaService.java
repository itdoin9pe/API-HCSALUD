package com.saludsystem.paciente.application.service.historialclinico.evolucion;

import com.saludsystem.paciente.application.dto.res.historialclinico.evolucion.NotaResponse;
import com.saludsystem.paciente.application.dto.req.historialclinico.evolucion.NotaRequest;
import com.saludsystem.paciente.application.dto.base.evolucion.ActualizarNotaDTO;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface NotaService {
    ApiResponse saveNota(NotaRequest notaRequest);
    NotaResponse getNotaById(Long pacienteEvolucionNotaId);
    ApiResponse updateNota(Long pacienteEvolucionNotaId, ActualizarNotaDTO actualizarNotaDTO);
    ListResponse<NotaResponse> getAllNota(UUID hospitalId, int page, int rows);
    ApiResponse deleteNota(Long pacienteEvolucionNotaId);
}