package com.saludsystem.domain.paciente.port.in.service.historialclinico;

import com.saludsystem.application.dto.get.historialclinico.PacienteAlergiaDTO;
import com.saludsystem.application.dto.post.historialclinico.CrearPacienteAlergiaDTO;
import com.saludsystem.application.dto.put.historialclinico.ActualizarPacienteAlergiaDTO;
import com.configuracion.application.services.GenericService;

import java.util.UUID;

public interface PacienteAlergiaService extends GenericService<
        PacienteAlergiaDTO,
        CrearPacienteAlergiaDTO,
        ActualizarPacienteAlergiaDTO,
        UUID> {
}