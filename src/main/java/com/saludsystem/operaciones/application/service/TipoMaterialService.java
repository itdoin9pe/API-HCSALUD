package com.saludsystem.operaciones.application.service;

import com.saludsystem.operaciones.application.dto.res.TipoMaterialDTO;
import com.saludsystem.operaciones.application.dto.req.CrearTipoMaterialDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface TipoMaterialService extends GenericService<
        CrearTipoMaterialDTO,
        TipoMaterialDTO,
        UUID> {
}