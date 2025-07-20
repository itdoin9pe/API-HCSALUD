package com.saludsystem.submodules.catalogo.command.delete;

import com.saludsystem.submodules.catalogo.service.tipoconcepto.TipoConceptoDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoConceptoDeleteHandler {

    private final TipoConceptoDeleteService tipoConceptoDeleteService;

    public TipoConceptoDeleteHandler(TipoConceptoDeleteService tipoConceptoDeleteService) {
        this.tipoConceptoDeleteService = tipoConceptoDeleteService;
    }

    public void execute(UUID uuid) {
        tipoConceptoDeleteService.execute(uuid);
    }
}
