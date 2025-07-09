package com.saludsystem.paciente.application.service;

import com.saludsystem.paciente.application.dto.get.EstudioResultadoDTO;
import com.saludsystem.paciente.application.dto.post.CrearEstudioResultadoDTO;
import com.saludsystem.paciente.application.dto.put.ActualizarEstudioResultadoDTO;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface EstudioResultadoService {

    ApiResponse saveEstudioResultado(CrearEstudioResultadoDTO crearEstudioResultadoDTO);

    ListResponse<EstudioResultadoDTO> getAllEstudioResultado(UUID hospitalId, int page, int rows);

    ApiResponse updateEstudioResultado(Long pacienteEstudioResultadoId, ActualizarEstudioResultadoDTO actualizarEstudioResultadoDTO);

    EstudioResultadoDTO getEstudioResultadoById(Long pacienteEstudioResultadoId);

    ApiResponse deleteEstudioResultado(Long pacienteEstudioResultadoId);

}