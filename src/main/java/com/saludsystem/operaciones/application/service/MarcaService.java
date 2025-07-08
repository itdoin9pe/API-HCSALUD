package com.saludsystem.operaciones.application.service;

import com.saludsystem.operaciones.application.dto.res.MarcaResponse;
import com.saludsystem.operaciones.application.dto.req.MarcaRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface MarcaService extends GenericService<
        MarcaRequest,
        MarcaResponse,
        UUID> {
}