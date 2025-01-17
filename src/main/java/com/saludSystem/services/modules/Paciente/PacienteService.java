package com.saludSystem.services.modules.Paciente;

import com.saludSystem.dtos.Paciente.CrearPacienteDTO;
import com.saludSystem.entities.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PacienteService {

    Paciente savePaciente(CrearPacienteDTO crearPacienteDTO);
    Page<CrearPacienteDTO> getAllPacientes(Pageable pageable);
}