package com.saludsystem.submodules.mantenimiento.command.create;

import com.saludsystem.submodules.mantenimiento.mapper.TipoTarjetaMapper;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.TipoTarjetaCreateCommand;
import com.saludsystem.submodules.mantenimiento.service.tipotarjeta.TipoTarjetaCreateService;
import org.springframework.stereotype.Component;

@Component
public class TipoTarjetaCreateHandler {

    private final TipoTarjetaCreateService tipoTarjetaCreateService;
    private final TipoTarjetaMapper tipoTarjetaMapper;

    public TipoTarjetaCreateHandler(TipoTarjetaCreateService tipoTarjetaCreateService, TipoTarjetaMapper tipoTarjetaMapper) {
        this.tipoTarjetaCreateService = tipoTarjetaCreateService;
        this.tipoTarjetaMapper = tipoTarjetaMapper;
    }

    public void execute(TipoTarjetaCreateCommand createCommand) {

        var tipoTarjeta = tipoTarjetaMapper.fromCreateDto(createCommand);

        tipoTarjetaCreateService.execute(tipoTarjeta);

    }

}
