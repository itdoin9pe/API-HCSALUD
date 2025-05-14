package com.saludSystem.application.services.Paciente;

import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarPacienteDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearPacienteDTO;
import com.saludSystem.application.dtos.Paciente.GET.PacienteDTO;
import com.saludSystem.domain.model.Paciente.PacienteEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PacienteService {

    PacienteEntity savePaciente(CrearPacienteDTO crearPacienteDTO);

    ActualizarPacienteDTO updatePaciente(UUID pacienteId, ActualizarPacienteDTO actualizarPacienteDTO);

    Optional<PacienteDTO> getPacienteById(UUID pacienteId);

    List<PacienteDTO> getPacienteList();

    ListResponse<PacienteDTO> getAllPaciente(UUID hospitalId, int page, int rows);

    ApiResponse deletePaciente(UUID pacienteId);

}