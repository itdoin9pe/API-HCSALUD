package com.saludSystem.application.services.Paciente.Evolucion;

import com.saludSystem.application.dtos.Paciente.GET.Evolucion.NotaDTO;
import com.saludSystem.application.dtos.Paciente.POST.Evolucion.CrearNotaDTO;
import com.saludSystem.application.dtos.Paciente.PUT.Evolucion.ActualizarNotaDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface NotaService {

    ApiResponse saveNota(CrearNotaDTO crearNotaDTO);

    NotaDTO getNotaById(Long pacienteEvolucionNotaId);

    ApiResponse updateNota(Long pacienteEvolucionNotaId, ActualizarNotaDTO actualizarNotaDTO);

    ListResponse<NotaDTO> getAllNota(UUID hospitalId, int page, int rows);

    ApiResponse deleteNota(Long pacienteEvolucionNotaId);

}