package com.saludsystem.submodules.catalogo.query.getList;

import com.saludsystem.submodules.catalogo.model.dto.TipoConceptoDTO;
import com.saludsystem.submodules.catalogo.service.tipoconcepto.TipoConceptoListService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TipoConceptoListHandler {

    private final TipoConceptoListService tipoConceptoListService;

    public TipoConceptoListHandler(TipoConceptoListService tipoConceptoListService) {
        this.tipoConceptoListService = tipoConceptoListService;
    }

    public List<TipoConceptoDTO> execute() {
        return tipoConceptoListService.execute();
    }
}
