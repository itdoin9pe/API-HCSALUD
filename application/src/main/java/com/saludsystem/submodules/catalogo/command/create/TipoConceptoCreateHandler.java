package com.saludsystem.submodules.catalogo.command.create;

import com.saludsystem.submodules.catalogo.mapper.TipoConceptoMapper;
import com.saludsystem.submodules.catalogo.model.dto.command.TipoConceptoCreateCommand;
import com.saludsystem.submodules.catalogo.service.tipoconcepto.TipoConceptoCreateService;
import org.springframework.stereotype.Component;

@Component
public class TipoConceptoCreateHandler {

    private final TipoConceptoCreateService tipoConceptoCreateService;
    private final TipoConceptoMapper tipoConceptoMapper;

    public TipoConceptoCreateHandler(TipoConceptoCreateService tipoConceptoCreateService, TipoConceptoMapper tipoConceptoMapper) {
        this.tipoConceptoCreateService = tipoConceptoCreateService;
        this.tipoConceptoMapper = tipoConceptoMapper;
    }

    public void execute(TipoConceptoCreateCommand createCommand) {

        var tipoConcepto = tipoConceptoMapper.fromCreateDto(createCommand);

        tipoConceptoCreateService.execute(tipoConcepto);

    }

}
