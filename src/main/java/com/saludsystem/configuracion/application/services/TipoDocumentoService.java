package com.saludsystem.configuracion.application.services;

import com.saludsystem.configuracion.application.dto.req.TipoDocumentoDTO;
import com.saludsystem.configuracion.application.dto.res.CrearTipoDocumentoDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface TipoDocumentoService extends GenericService<
        CrearTipoDocumentoDTO,
        TipoDocumentoDTO,
        UUID> {
}