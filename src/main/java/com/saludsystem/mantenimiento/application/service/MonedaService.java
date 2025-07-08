package com.saludsystem.mantenimiento.application.service;

import com.saludsystem.mantenimiento.application.dto.res.MonedaResponse;
import com.saludsystem.mantenimiento.application.dto.req.MonedaRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface MonedaService extends GenericService<
        MonedaRequest,
        MonedaResponse,
        UUID> {
}