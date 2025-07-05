package com.saludsystem.application.services.paciente.historialClinico.evolucion;

import com.saludsystem.application.dtos.paciente.get.historialclinico.evolucion.NotaDTO;
import com.saludsystem.application.dtos.paciente.post.historialclinico.evolucion.CrearNotaDTO;
import com.saludsystem.application.dtos.paciente.put.historialclinico.evolucion.ActualizarNotaDTO;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface NotaService {
    ApiResponse saveNota(CrearNotaDTO crearNotaDTO);
    NotaDTO getNotaById(Long pacienteEvolucionNotaId);
    ApiResponse updateNota(Long pacienteEvolucionNotaId, ActualizarNotaDTO actualizarNotaDTO);
    ListResponse<NotaDTO> getAllNota(UUID hospitalId, int page, int rows);
    ApiResponse deleteNota(Long pacienteEvolucionNotaId);
}