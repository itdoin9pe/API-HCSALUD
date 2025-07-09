package com.saludsystem.paciente.application.service;

import com.saludsystem.paciente.application.dto.get.DiagnosticoDTO;
import com.saludsystem.paciente.application.dto.post.CrearDiagnosticoDTO;
import com.saludsystem.paciente.application.dto.put.ActualizarDiagnosticoDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface DiagnosticoService extends GenericService<
        DiagnosticoDTO,
        CrearDiagnosticoDTO,
        ActualizarDiagnosticoDTO,
        UUID> {
}