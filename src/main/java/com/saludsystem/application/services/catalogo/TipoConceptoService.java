package com.saludsystem.application.services.catalogo;

import com.saludsystem.application.dtos.catalogo.req.TipoConceptoDTO;
import com.saludsystem.application.dtos.catalogo.post.CrearTipoConceptoDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface TipoConceptoService extends GenericService<
        CrearTipoConceptoDTO,
        TipoConceptoDTO,
        UUID> {
}