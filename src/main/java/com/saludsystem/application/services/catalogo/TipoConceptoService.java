package com.saludsystem.application.services.catalogo;

import com.saludsystem.application.dtos.catalogo.get.TipoConceptoDTO;
import com.saludsystem.application.dtos.catalogo.post.CrearTipoConceptoDTO;
import com.saludsystem.application.dtos.catalogo.put.ActualizarTipoConceptoDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface TipoConceptoService extends GenericService<
        TipoConceptoDTO,
        UUID,
        CrearTipoConceptoDTO,
        ActualizarTipoConceptoDTO> {
}