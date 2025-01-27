package com.saludSystem.services.modules.Paciente;

import com.saludSystem.dtos.Paciente.CrearPacienteDTO;
import com.saludSystem.entities.*;
import com.saludSystem.services.PaginatedService;

import java.util.List;

public interface PacienteService extends PaginatedService {

    Paciente savePaciente(CrearPacienteDTO crearPacienteDTO);

    long getTotalCount();

}