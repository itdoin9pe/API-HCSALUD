package com.saludSystem.Paciente.aplicacion.services;

import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Paciente.aplicacion.dtos.ActualizarPacienteDTO;
import com.saludSystem.Paciente.aplicacion.dtos.CrearPacienteDTO;
import com.saludSystem.Paciente.aplicacion.dtos.PacienteDTO;
import com.saludSystem.Paciente.dominio.PacienteModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PacienteService {

    PacienteModel savePaciente(CrearPacienteDTO crearPacienteDTO);

    ActualizarPacienteDTO updatePaciente(UUID pacienteId, ActualizarPacienteDTO actualizarPacienteDTO);

    Optional<PacienteDTO> getPacienteById(UUID pacienteId);

    List<PacienteDTO> getPacienteList();

    ListResponse<PacienteDTO> getAllPaciente(UUID hospitalId, int page, int rows);

    ApiResponse deletePaciente(UUID pacienteId);

}