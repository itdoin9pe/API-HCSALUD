package com.saludsystem.paciente.application.service.historialclinico;

import com.saludsystem.paciente.application.dto.get.historialclinico.PacienteAlergiaDTO;
import com.saludsystem.paciente.application.dto.post.historialclinico.CrearPacienteAlergiaDTO;
import com.saludsystem.paciente.application.dto.put.historialclinico.ActualizarPacienteAlergiaDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface PacienteAlergiaService extends GenericService<
        PacienteAlergiaDTO,
        CrearPacienteAlergiaDTO,
        ActualizarPacienteAlergiaDTO,
        UUID> {
}