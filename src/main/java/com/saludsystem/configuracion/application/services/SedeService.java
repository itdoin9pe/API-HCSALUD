package com.saludsystem.configuracion.application.services;

import com.saludsystem.configuracion.application.dto.res.SedeResponse;
import com.saludsystem.configuracion.application.dto.req.SedeRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface SedeService extends GenericService<
        SedeRequest,
        SedeResponse,
        UUID> {
}