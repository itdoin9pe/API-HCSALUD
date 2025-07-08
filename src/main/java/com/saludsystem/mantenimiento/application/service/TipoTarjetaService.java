package com.saludsystem.mantenimiento.application.service;

import com.saludsystem.mantenimiento.application.dto.res.TipoTarjetaResponse;
import com.saludsystem.mantenimiento.application.dto.req.TipoTarjetaRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface TipoTarjetaService extends GenericService<
        TipoTarjetaRequest,
        TipoTarjetaResponse,
        UUID> {
}