package com.saludsystem.submodules.mantenimiento.command.create;

import com.saludsystem.submodules.mantenimiento.mapper.TipoGastoMapper;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.TipoGastoCreateCommand;
import com.saludsystem.submodules.mantenimiento.service.tipogasto.TipoGastoCreateService;
import org.springframework.stereotype.Component;

@Component
public class TipoGastoCreateHandler {

    private final TipoGastoCreateService tipoGastoCreateService;
    private final TipoGastoMapper tipoGastoMapper;

    public TipoGastoCreateHandler(TipoGastoCreateService tipoGastoCreateService, TipoGastoMapper tipoGastoMapper) {
        this.tipoGastoCreateService = tipoGastoCreateService;
        this.tipoGastoMapper = tipoGastoMapper;
    }

    public void execute(TipoGastoCreateCommand createCommand) {

        var tipoGasto = tipoGastoMapper.fromCreateDto(createCommand);

        tipoGastoCreateService.execute(tipoGasto);

    }

}
