package com.saludsystem.mantenimiento.application.service;

import com.saludsystem.mantenimiento.application.dto.res.CajaResponse;
import com.saludsystem.mantenimiento.application.dto.req.CajaRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface CajaService extends GenericService<
        CajaRequest,
        CajaResponse,
        UUID> {
}