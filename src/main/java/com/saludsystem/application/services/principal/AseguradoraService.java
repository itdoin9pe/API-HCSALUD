package com.saludsystem.application.services.principal;

import com.saludsystem.application.dtos.principal.res.AseguradoraResponse;
import com.saludsystem.application.dtos.principal.req.AseguradoraRequest;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface AseguradoraService extends GenericService<
        AseguradoraRequest,
        AseguradoraResponse,
        UUID> {
}