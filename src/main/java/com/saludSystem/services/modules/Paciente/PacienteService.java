package com.saludSystem.services.modules.Paciente;

import com.saludSystem.dtos.Paciente.CrearPacienteDTO;
import com.saludSystem.entities.*;

import java.util.List;

public interface PacienteService {

    Paciente savePaciente(CrearPacienteDTO crearPacienteDTO);
    List<CrearPacienteDTO> getAllPaciente(int page, int rows);
    long getTotalCount();
}