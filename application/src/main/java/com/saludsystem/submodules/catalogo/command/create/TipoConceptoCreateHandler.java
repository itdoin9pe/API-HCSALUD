package com.saludsystem.submodules.catalogo.command.create;

import com.saludsystem.submodules.catalogo.dto.command.CrearTipoConceptoDTO;
import com.saludsystem.submodules.catalogo.service.tipoconcepto.TipoConceptoCreateService;
import org.springframework.stereotype.Component;

@Component
public class TipoConceptoCreateHandler {

    private final TipoConceptoCreateService tipoConceptoCreateService;

    public TipoConceptoCreateHandler(TipoConceptoCreateService tipoConceptoCreateService) {
        this.tipoConceptoCreateService = tipoConceptoCreateService;
    }

    public void execute(CrearTipoConceptoDTO dto) {
        tipoConceptoCreateService.execute(dto);
    }
}
