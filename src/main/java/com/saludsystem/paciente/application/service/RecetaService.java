package com.saludsystem.paciente.application.service;

import com.saludsystem.paciente.application.dto.res.RecetaResponse;
import com.saludsystem.paciente.application.dto.req.RecetaRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface RecetaService extends GenericService<
        RecetaRequest,
        RecetaResponse,
        UUID> {
}