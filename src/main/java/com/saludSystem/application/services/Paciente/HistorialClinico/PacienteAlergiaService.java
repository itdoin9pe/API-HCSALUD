package com.saludSystem.application.services.Paciente.HistorialClinico;

import com.saludSystem.application.dtos.Paciente.GET.HistorialClinico.PacienteAlergiaDTO;
import com.saludSystem.application.dtos.Paciente.POST.HistorialClinico.CrearPacienteAlergiaDTO;
import com.saludSystem.application.dtos.Paciente.PUT.HistorialClinico.ActualizarPacienteAlergiaDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface PacienteAlergiaService {

    ApiResponse savePacienteAlergia(CrearPacienteAlergiaDTO crearPacienteAlergiaDTO);

    ApiResponse updatePacienteAlergia(UUID pacienteAlergiaId, ActualizarPacienteAlergiaDTO actualizarPacienteAlergiaDTO);

    PacienteAlergiaDTO getPacienteAlergiaById(UUID pacienteAlergiaId);

    ListResponse<PacienteAlergiaDTO> getAllPacienteAlergia(UUID hospitalId, int page, int rows);

    ApiResponse deletePacienteAlergia(UUID pacienteAlergiaId);

}