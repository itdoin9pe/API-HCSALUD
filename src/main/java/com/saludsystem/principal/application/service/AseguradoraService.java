package com.saludsystem.principal.application.service;

import com.saludsystem.principal.application.dto.res.AseguradoraResponse;
import com.saludsystem.principal.application.dto.req.AseguradoraRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface AseguradoraService extends GenericService<
        AseguradoraRequest,
        AseguradoraResponse,
        UUID> {
}