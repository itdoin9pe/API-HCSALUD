package com.saludsystem.application.services.paciente.historialclinico;

import com.saludsystem.application.dtos.paciente.get.historialclinico.PacienteAlergiaDTO;
import com.saludsystem.application.dtos.paciente.post.historialclinico.CrearPacienteAlergiaDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface PacienteAlergiaService extends GenericService<
        CrearPacienteAlergiaDTO,
        PacienteAlergiaDTO,
        UUID> {
}