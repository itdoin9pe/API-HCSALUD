package com.saludsystem.submodules.mantenimiento.command.edit;

import com.saludsystem.submodules.mantenimiento.mapper.TipoTarjetaMapper;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.edit.TipoTarjetaEditCommand;
import com.saludsystem.submodules.mantenimiento.service.tipotarjeta.TipoTarjetaEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoTarjetaEditHandler {

    private final TipoTarjetaEditService tipoTarjetaEditService;
    private final TipoTarjetaMapper tipoTarjetaMapper;

    public TipoTarjetaEditHandler(TipoTarjetaEditService tipoTarjetaEditService, TipoTarjetaMapper tipoTarjetaMapper) {
        this.tipoTarjetaEditService = tipoTarjetaEditService;
        this.tipoTarjetaMapper = tipoTarjetaMapper;
    }

    public void execute(UUID uuid, TipoTarjetaEditCommand editCommand) {

        var tipoTarjeta = tipoTarjetaMapper.fromUpdateDto(uuid, editCommand);

        tipoTarjetaEditService.execute(uuid, tipoTarjeta);

    }

}
