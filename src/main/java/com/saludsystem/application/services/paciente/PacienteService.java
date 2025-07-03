package com.saludsystem.application.services.paciente;

import com.saludsystem.application.dtos.paciente.get.PacienteDTO;
import com.saludsystem.application.dtos.paciente.post.CrearPacienteDTO;
import com.saludsystem.application.dtos.paciente.put.ActualizarPacienteDTO;
import com.saludsystem.domain.model.paciente.PacienteEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;

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