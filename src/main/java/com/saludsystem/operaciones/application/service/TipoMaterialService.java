package com.saludsystem.operaciones.application.service;

import com.saludsystem.operaciones.application.dto.get.TipoMaterialDTO;
import com.saludsystem.operaciones.application.dto.post.CrearTipoMaterialDTO;
import com.saludsystem.operaciones.application.dto.put.ActualizarTipoMaterialDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface TipoMaterialService extends GenericService<
        TipoMaterialDTO,
        CrearTipoMaterialDTO,
        ActualizarTipoMaterialDTO,
        UUID> {
}