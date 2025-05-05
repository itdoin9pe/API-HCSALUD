package com.saludSystem.application.services.Paciente;

import com.saludSystem.application.dtos.Paciente.GET.AnalisisOclusal1DTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearAnalisisOclusal1DTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarAnalisisOclusal1DTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface AnalisisOclusal1Service {

    ApiResponse saveAnalisis1Oclusal(CrearAnalisisOclusal1DTO crearAnalisisOclusal1DTO);

    ApiResponse deleteAnalisis1Oclusal(UUID pacienteAnalisisOclusal1Id);

    AnalisisOclusal1DTO getAnalisisOclusal1ById(UUID pacienteAnalisisOclusal1Id);

    ApiResponse updateAnalisisOclusal1(UUID pacienteAnalisisOclusal1Id, ActualizarAnalisisOclusal1DTO actualizarAnalisisOclusal1DTO);

    ListResponse<AnalisisOclusal1DTO> getAllAnalisisOclusal1(UUID hospitalId, int page, int rows);

}