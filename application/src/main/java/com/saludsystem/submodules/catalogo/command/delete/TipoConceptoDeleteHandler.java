package com.saludsystem.submodules.catalogo.command.delete;

import com.saludsystem.submodules.catalogo.port.in.service.TipoConceptoService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoConceptoDeleteHandler {
    private final TipoConceptoService tipoConceptoService;

    public TipoConceptoDeleteHandler(TipoConceptoService tipoConceptoService) {
        this.tipoConceptoService = tipoConceptoService;
    }

    public void execute(UUID uuid) {
        tipoConceptoService.delete(uuid);
    }
}
