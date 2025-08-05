package com.saludsystem.submodules.configuracion.command.create;

import com.saludsystem.submodules.configuracion.mapper.TipoDocumentoMapper;
import com.saludsystem.submodules.configuracion.model.dtos.command.TipoDocumentoCreateCommand;
import com.saludsystem.submodules.configuracion.service.tipodocumento.TipoDocumentoCreateService;
import org.springframework.stereotype.Component;

@Component
public class TipoDocumentoCreateHandler {

    private final TipoDocumentoCreateService tipoDocumentoCreateService;
    private final TipoDocumentoMapper tipoDocumentoMapper;

    public TipoDocumentoCreateHandler(TipoDocumentoCreateService tipoDocumentoCreateService, TipoDocumentoMapper tipoDocumentoMapper) {
        this.tipoDocumentoCreateService = tipoDocumentoCreateService;
        this.tipoDocumentoMapper = tipoDocumentoMapper;
    }

    public void execute(TipoDocumentoCreateCommand createCommand) {

        var tipoDocSaved = tipoDocumentoMapper.fromCreateDto(createCommand);

        tipoDocumentoCreateService.execute(tipoDocSaved);

    }

}
