package com.saludsystem.configuracion.application.services;

import com.saludsystem.configuracion.application.dto.get.TipoDocumentoDTO;
import com.saludsystem.configuracion.application.dto.post.CrearTipoDocumentoDTO;
import com.saludsystem.configuracion.application.dto.put.ActualizarTipoDocumentoDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface TipoDocumentoService extends GenericService<
        TipoDocumentoDTO,
        CrearTipoDocumentoDTO,
        ActualizarTipoDocumentoDTO,
        UUID> {
}