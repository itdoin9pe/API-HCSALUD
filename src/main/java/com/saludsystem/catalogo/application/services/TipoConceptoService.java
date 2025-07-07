package com.saludsystem.catalogo.application.services;

import com.saludsystem.catalogo.application.dtos.res.TipoConceptoDTO;
import com.saludsystem.catalogo.application.dtos.req.CrearTipoConceptoDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface TipoConceptoService extends GenericService<
        CrearTipoConceptoDTO,
        TipoConceptoDTO,
        UUID> {
}