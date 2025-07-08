package com.saludsystem.catalogo.application.services;

import com.saludsystem.catalogo.application.dtos.res.TipoConceptoRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface TipoConceptoService extends GenericService<
        com.saludsystem.catalogo.application.dtos.req.TipoConceptoRequest,
        TipoConceptoRequest,
        UUID> {
}