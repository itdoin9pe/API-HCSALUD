package com.saludsystem.application.services.operaciones;

import com.saludsystem.application.dtos.operaciones.get.TipoMaterialDTO;
import com.saludsystem.application.dtos.operaciones.post.CrearTipoMaterialDTO;
import com.saludsystem.application.dtos.operaciones.put.ActualizarTipoMaterialDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface TipoMaterialService extends GenericService<
        TipoMaterialDTO,
        UUID,
        CrearTipoMaterialDTO,
        ActualizarTipoMaterialDTO> {
}