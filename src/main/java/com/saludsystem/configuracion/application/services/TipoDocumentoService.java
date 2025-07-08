package com.saludsystem.configuracion.application.services;

import com.saludsystem.configuracion.application.dto.res.TipoDocumentoResponse;
import com.saludsystem.configuracion.application.dto.req.TipoDocumentoRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface TipoDocumentoService extends GenericService<
        TipoDocumentoRequest,
        TipoDocumentoResponse,
        UUID> {
}