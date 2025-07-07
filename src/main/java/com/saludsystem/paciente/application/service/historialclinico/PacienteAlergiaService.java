package com.saludsystem.paciente.application.service.historialclinico;

import com.saludsystem.paciente.application.dto.res.historialclinico.PacienteAlergiaDTO;
import com.saludsystem.paciente.application.dto.req.historialclinico.CrearPacienteAlergiaDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface PacienteAlergiaService extends GenericService<
        CrearPacienteAlergiaDTO,
        PacienteAlergiaDTO,
        UUID> {
}