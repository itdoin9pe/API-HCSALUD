package com.saludsystem.mantenimiento.application.service;

import com.saludsystem.mantenimiento.application.dto.res.TipoGastoResponse;
import com.saludsystem.mantenimiento.application.dto.req.TipoGastoRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface TipoGastoService extends GenericService<
        TipoGastoRequest,
        TipoGastoResponse,
        UUID> {
}