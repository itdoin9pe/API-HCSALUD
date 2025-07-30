package com.saludsystem.submodules.catalogo.query.getById;

import com.saludsystem.submodules.catalogo.dto.TipoConceptoDTO;
import com.saludsystem.submodules.catalogo.service.tipoconcepto.TipoConceptoByIdService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoConceptoByIdHandler {

    public final TipoConceptoByIdService tipoConceptoByIdService;

    public TipoConceptoByIdHandler(TipoConceptoByIdService tipoConceptoByIdService) {
        this.tipoConceptoByIdService = tipoConceptoByIdService;
    }

    public TipoConceptoDTO execute(UUID uuid) {
        return tipoConceptoByIdService.execute(uuid);
    }
}
