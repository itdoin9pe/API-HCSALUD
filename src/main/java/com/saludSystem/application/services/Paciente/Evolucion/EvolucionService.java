package com.saludSystem.application.services.Paciente.Evolucion;

import com.saludSystem.application.dtos.Paciente.GET.Evolucion.EvolucionDTO;
import com.saludSystem.application.dtos.Paciente.POST.Evolucion.CrearEvolucionDTO;
import com.saludSystem.application.dtos.Paciente.PUT.Evolucion.ActualizarEvolucionDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface EvolucionService {

    ApiResponse saveEvolucion(CrearEvolucionDTO crearEvolucionDTO);

    ListResponse<EvolucionDTO> getAllEvolucion(UUID hospitalId, int page, int rows);

    EvolucionDTO getEvolucionById(UUID pacienteEvolucionId);

    ApiResponse updateEvolucion(UUID pacienteEvolucionId, ActualizarEvolucionDTO actualizarEvolucionDTO);

    ApiResponse deleteEvolucion(UUID pacienteEvolucionId);

}