package com.saludsystem.application.services.paciente.Evolucion;

import com.saludsystem.application.dtos.paciente.get.evolucion.NotaDTO;
import com.saludsystem.application.dtos.paciente.post.evolucion.CrearNotaDTO;
import com.saludsystem.application.dtos.paciente.put.evolucion.ActualizarNotaDTO;
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