package com.saludsystem.domain.paciente.port.in.service;

import com.saludsystem.application.dto.get.PacienteDTO;
import com.saludsystem.application.dto.post.CrearPacienteDTO;
import com.saludsystem.application.dto.put.ActualizarPacienteDTO;
import com.saludsystem.domain.model.PacienteEntity;
import com.shared.infrastructure.adapters.in.response.ApiResponse;
import com.shared.infrastructure.adapters.in.response.ListResponse;

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