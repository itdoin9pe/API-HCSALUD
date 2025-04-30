package com.saludSystem.application.services.Paciente;

import com.saludSystem.application.dtos.Paciente.GET.AnalisisGeneralDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearAnalisisGeneralDTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarAnalisisGeneralDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface AnalisisGeneralService {

    ApiResponse saveAnalisisGeneral(CrearAnalisisGeneralDTO crearAnalisisGeneralDTO);

    ApiResponse updateAnalisisGeneral(UUID pacienteAnalisisGeneralId, ActualizarAnalisisGeneralDTO actualizarAnalisisGeneralDTO);

    ListResponse<AnalisisGeneralDTO> getAllAnalisisGeneral(UUID hospitalId, int page, int rows);

    AnalisisGeneralDTO getAnalisisGeneralById(UUID pacienteAnalisisGeneralId);

    ApiResponse deleteAnalisisGeneral(UUID pacienteAnalisisGeneralId);

}