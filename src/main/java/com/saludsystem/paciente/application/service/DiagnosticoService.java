package com.saludsystem.paciente.application.service;

import com.saludsystem.paciente.application.dto.res.DiagnosticoResponse;
import com.saludsystem.paciente.application.dto.req.DiagnosticoRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface DiagnosticoService extends GenericService<
        DiagnosticoRequest,
        DiagnosticoResponse,
        UUID> {
}