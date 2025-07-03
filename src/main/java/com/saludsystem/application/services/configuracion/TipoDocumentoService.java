package com.saludsystem.application.services.configuracion;

import com.saludsystem.application.dtos.configuracion.get.TipoDocumentoDTO;
import com.saludsystem.application.dtos.configuracion.post.CrearTipoDocumentoDTO;
import com.saludsystem.application.dtos.configuracion.put.ActualizarTipoDocumentoDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface TipoDocumentoService extends GenericService<
        TipoDocumentoDTO,
        UUID,
        CrearTipoDocumentoDTO,
        ActualizarTipoDocumentoDTO> {
}