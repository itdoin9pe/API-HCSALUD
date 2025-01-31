package com.saludSystem.services.modules.Paciente;

import com.saludSystem.dtos.Paciente.ActualizarPacienteDTO;
import com.saludSystem.dtos.Paciente.CrearPacienteDTO;
import com.saludSystem.dtos.Paciente.PacienteDTO;
import com.saludSystem.entities.*;
import com.saludSystem.services.PaginatedService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PacienteService extends PaginatedService {

    Paciente savePaciente(CrearPacienteDTO crearPacienteDTO);

    ActualizarPacienteDTO updatePaciente(UUID pacienteId, ActualizarPacienteDTO actualizarPacienteDTO);

    Optional<PacienteDTO> getPacienteById(UUID pacienteId);

    List<PacienteDTO> getPacienteList();

    void deletePaciente(UUID pacienteId);

}