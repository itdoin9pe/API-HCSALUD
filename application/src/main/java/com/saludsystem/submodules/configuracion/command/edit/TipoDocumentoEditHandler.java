package com.saludsystem.submodules.configuracion.command.edit;

import com.saludsystem.submodules.configuracion.mapper.TipoDocumentoMapper;
import com.saludsystem.submodules.configuracion.model.dtos.command.edit.TipoDocumentoEditCommand;
import com.saludsystem.submodules.configuracion.service.tipodocumento.TipoDocumentoEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoDocumentoEditHandler {

    private final TipoDocumentoEditService tipoDocumentoEditService;
    private final TipoDocumentoMapper tipoDocumentoMapper;

    public TipoDocumentoEditHandler(TipoDocumentoEditService tipoDocumentoEditService, TipoDocumentoMapper tipoDocumentoMapper) {
        this.tipoDocumentoEditService = tipoDocumentoEditService;
        this.tipoDocumentoMapper = tipoDocumentoMapper;
    }

    public void execute(UUID uuid, TipoDocumentoEditCommand editCommand) {

        var tipoDocUpdated = tipoDocumentoMapper.fromUpdateDto(uuid, editCommand);

        tipoDocumentoEditService.execute(uuid, tipoDocUpdated);

    }

}
