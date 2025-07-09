package com.saludsystem.paciente.application.service;

import com.saludsystem.paciente.application.dto.get.PacienteDTO;
import com.saludsystem.paciente.application.dto.post.CrearPacienteDTO;
import com.saludsystem.paciente.application.dto.put.ActualizarPacienteDTO;
import com.saludsystem.paciente.domain.model.PacienteEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;

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