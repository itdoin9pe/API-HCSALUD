package com.saludsystem.paciente.application.service;

import com.saludsystem.paciente.application.dto.res.PacienteResponse;
import com.saludsystem.paciente.application.dto.req.PacienteRequest;
import com.saludsystem.paciente.application.dto.ActualizarPacienteDTO;
import com.saludsystem.paciente.domain.model.PacienteEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PacienteService {

    PacienteEntity savePaciente(PacienteRequest pacienteRequest);

    ActualizarPacienteDTO updatePaciente(UUID pacienteId, ActualizarPacienteDTO actualizarPacienteDTO);

    Optional<PacienteResponse> getPacienteById(UUID pacienteId);

    List<PacienteResponse> getPacienteList();

    ListResponse<PacienteResponse> getAllPaciente(UUID hospitalId, int page, int rows);

    ApiResponse deletePaciente(UUID pacienteId);

}