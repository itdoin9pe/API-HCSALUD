package com.saludsystem.operaciones.application.service;

import com.saludsystem.operaciones.application.dto.res.TipoMaterialResponse;
import com.saludsystem.operaciones.application.dto.req.TipoMaterialRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface TipoMaterialService extends GenericService<
        TipoMaterialRequest,
        TipoMaterialResponse,
        UUID> {
}