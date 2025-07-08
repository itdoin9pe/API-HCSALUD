package com.saludsystem.mantenimiento.application.service;

import com.saludsystem.mantenimiento.application.dto.res.TarifarioResponse;
import com.saludsystem.mantenimiento.application.dto.req.TarifarioRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface TarifarioService extends GenericService<
        TarifarioRequest,
        TarifarioResponse,
        UUID> {
}