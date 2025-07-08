package com.saludsystem.paciente.application.service;

import com.saludsystem.paciente.application.dto.res.EstudioResultadoResponse;
import com.saludsystem.paciente.application.dto.req.EstudioResultadoRequest;
import com.saludsystem.paciente.application.dto.base.ActualizarEstudioResultadoDTO;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface EstudioResultadoService {

    ApiResponse saveEstudioResultado(EstudioResultadoRequest estudioResultadoRequest);

    ListResponse<EstudioResultadoResponse> getAllEstudioResultado(UUID hospitalId, int page, int rows);

    ApiResponse updateEstudioResultado(Long pacienteEstudioResultadoId, ActualizarEstudioResultadoDTO actualizarEstudioResultadoDTO);

    EstudioResultadoResponse getEstudioResultadoById(Long pacienteEstudioResultadoId);

    ApiResponse deleteEstudioResultado(Long pacienteEstudioResultadoId);

}