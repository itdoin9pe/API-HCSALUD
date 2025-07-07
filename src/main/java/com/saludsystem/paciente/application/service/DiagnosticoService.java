package com.saludsystem.paciente.application.service;

import com.saludsystem.paciente.application.dto.res.DiagnosticoDTO;
import com.saludsystem.paciente.application.dto.req.CrearDiagnosticoDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface DiagnosticoService extends GenericService<
        CrearDiagnosticoDTO,
        DiagnosticoDTO,
        UUID> {
}