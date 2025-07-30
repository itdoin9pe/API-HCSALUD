package com.saludsystem.submodules.catalogo.command.edit;

import com.saludsystem.submodules.catalogo.dto.edit.ActualizarTipoConceptoDTO;
import com.saludsystem.submodules.catalogo.service.tipoconcepto.TipoConceptoEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoConceptoEditHandler {

    private final TipoConceptoEditService tipoConceptoEditService;

    public TipoConceptoEditHandler(TipoConceptoEditService tipoConceptoEditService) {
        this.tipoConceptoEditService = tipoConceptoEditService;
    }

    public void execute(UUID uuid, ActualizarTipoConceptoDTO dto) {
        tipoConceptoEditService.execute(uuid, dto);
    }
}
