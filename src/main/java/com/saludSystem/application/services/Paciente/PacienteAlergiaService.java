package com.saludSystem.application.services.Paciente;

import com.saludSystem.application.dtos.Paciente.GET.PacienteAlergiaDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearPacienteAlergiaDTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarPacienteAlergiaDTO;
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