package com.saludsystem.domain.configuracion.port.in.service;

import com.configuracion.application.dto.get.TipoDocumentoDTO;
import com.configuracion.application.dto.post.CrearTipoDocumentoDTO;
import com.configuracion.application.dto.put.ActualizarTipoDocumentoDTO;
import com.saludsystem.domain.shared.port.in.GenericService;

import java.util.UUID;

public interface TipoDocumentoService extends GenericService<
        TipoDocumentoDTO,
        CrearTipoDocumentoDTO,
        ActualizarTipoDocumentoDTO,
        UUID> {
}