package com.saludSystem.application.services.Paciente;

import com.saludSystem.application.dtos.Paciente.GET.ConsultaDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearConsultaDTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarConsultaDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface ConsultaService {

    ApiResponse saveConsulta(CrearConsultaDTO crearConsultaDTO);

    ConsultaDTO getConsultaById(UUID pacienteConsultaId);

    ListResponse<ConsultaDTO> getAllConsulta(UUID hospitalId, int page, int rows);

    ApiResponse updateConsulta(UUID pacienteConsultaId, ActualizarConsultaDTO actualizarConsultaDTO);

    ApiResponse deleteConsulta(UUID pacienteConsultaId);

}