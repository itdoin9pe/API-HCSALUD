package com.saludSystem.application.services.Paciente;

import com.saludSystem.application.dtos.Paciente.GET.DiagnosticoDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearDiagnosticoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarDiagnosticoDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface DiagnosticoService {

    ApiResponse saveDiagnostico(CrearDiagnosticoDTO crearDiagnosticoDTO);

    ListResponse<DiagnosticoDTO> getAllDiagnotico(UUID pacienteDiagnosticoId, int page, int rows);

    ApiResponse updateDiagnostico(UUID pacienteDiagnosticoId, ActualizarDiagnosticoDTO actualizarDiagnosticoDTO);

    DiagnosticoDTO getDiagnosticoById(UUID pacienteDiagnosticoId);

    ApiResponse deleteDiagnostico(UUID pacienteDiagnosticoId);

}