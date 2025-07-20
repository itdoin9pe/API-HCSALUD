package com.saludsystem.submodules.catalogo.query.getAll;

import com.saludsystem.submodules.catalogo.model.dto.TipoConceptoDTO;
import com.saludsystem.submodules.catalogo.service.tipoconcepto.TipoConceptoAllService;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoConceptoAllHandler {

    private final TipoConceptoAllService tipoConceptoAllService;

    public TipoConceptoAllHandler(TipoConceptoAllService tipoConceptoAllService) {
        this.tipoConceptoAllService = tipoConceptoAllService;
    }

    public ListResponse<TipoConceptoDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {
        return tipoConceptoAllService.execute(hospitalId, paginationRequest);
    }
}
