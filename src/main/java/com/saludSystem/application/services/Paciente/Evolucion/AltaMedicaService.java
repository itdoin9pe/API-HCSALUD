package com.saludSystem.application.services.Paciente.Evolucion;

import com.saludSystem.application.dtos.Paciente.GET.Evolucion.AltaMedicaDTO;
import com.saludSystem.application.dtos.Paciente.POST.Evolucion.CrearAltaMedicaDTO;
import com.saludSystem.application.dtos.Paciente.PUT.Evolucion.ActualizarAltaMedicaDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface AltaMedicaService {

    ApiResponse saveAltaMedica(CrearAltaMedicaDTO crearAltaMedicaDTO);

    AltaMedicaDTO getAltaMedicaById(Long evolucionAltaMedicaId);

    ApiResponse updateAltaMedica(Long evolucionAltaMedicaId, ActualizarAltaMedicaDTO actualizarAltaMedicaDTO);

    ListResponse<AltaMedicaDTO> getAllAltaMedica(UUID hospitalId, int page, int rows);

    ApiResponse deleteAltaMedica(Long evolucionAltaMedicaId);

}