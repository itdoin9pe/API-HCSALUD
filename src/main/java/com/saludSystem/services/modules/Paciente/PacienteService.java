package com.saludSystem.services.modules.Paciente;

import com.saludSystem.dtos.Paciente.ActualizarPacienteDTO;
import com.saludSystem.dtos.Paciente.CrearPacienteDTO;
import com.saludSystem.entities.*;
import com.saludSystem.services.PaginatedService;

import java.util.UUID;

public interface PacienteService extends PaginatedService {

    Paciente savePaciente(CrearPacienteDTO crearPacienteDTO);

    ActualizarPacienteDTO updatePaciente(UUID pacienteId, ActualizarPacienteDTO actualizarPacienteDTO);

    long getTotalCount();

}