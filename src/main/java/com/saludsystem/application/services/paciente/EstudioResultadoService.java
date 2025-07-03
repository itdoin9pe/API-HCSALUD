package com.saludsystem.application.services.paciente;

import com.saludsystem.application.dtos.paciente.get.EstudioResultadoDTO;
import com.saludsystem.application.dtos.paciente.post.CrearEstudioResultadoDTO;
import com.saludsystem.application.dtos.paciente.put.ActualizarEstudioResultadoDTO;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface EstudioResultadoService {

    ApiResponse saveEstudioResultado(CrearEstudioResultadoDTO crearEstudioResultadoDTO);

    ListResponse<EstudioResultadoDTO> getAllEstudioResultado(UUID hospitalId, int page, int rows);

    ApiResponse updateEstudioResultado(Long pacienteEstudioResultadoId, ActualizarEstudioResultadoDTO actualizarEstudioResultadoDTO);

    EstudioResultadoDTO getEstudioResultadoById(Long pacienteEstudioResultadoId);

    ApiResponse deleteEstudioResultado(Long pacienteEstudioResultadoId);

}