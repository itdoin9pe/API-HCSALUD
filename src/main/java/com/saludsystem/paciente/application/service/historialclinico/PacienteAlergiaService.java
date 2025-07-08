package com.saludsystem.paciente.application.service.historialclinico;

import com.saludsystem.paciente.application.dto.res.historialclinico.PacienteAlergiaResponse;
import com.saludsystem.paciente.application.dto.req.historialclinico.PacienteAlergiaRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface PacienteAlergiaService extends GenericService<
        PacienteAlergiaRequest,
        PacienteAlergiaResponse,
        UUID> {
}