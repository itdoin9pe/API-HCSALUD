package com.saludSystem.application.services.Paciente;

import com.saludSystem.application.dtos.Paciente.GET.EstudioResultadoDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearEstudioResultadoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarEstudioResultadoDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface EstudioResultadoService {

    ApiResponse saveEstudioResultado(CrearEstudioResultadoDTO crearEstudioResultadoDTO);

    ListResponse<EstudioResultadoDTO> getAllEstudioResultado(UUID hospitalId, int page, int rows);

    ApiResponse updateEstudioResultado(Long pacienteEstudioResultadoId, ActualizarEstudioResultadoDTO actualizarEstudioResultadoDTO);

    EstudioResultadoDTO getEstudioResultadoById(Long pacienteEstudioResultadoId);

    ApiResponse deleteEstudioResultado(Long pacienteEstudioResultadoId);

}