package com.saludsystem.submodules.mantenimiento.command.edit;

import com.saludsystem.submodules.mantenimiento.mapper.TipoGastoMapper;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.edit.TipoGastoEditCommand;
import com.saludsystem.submodules.mantenimiento.service.tipogasto.TipoGastoEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoGastoEditHandler {

    private final TipoGastoEditService tipoGastoEditService;
    private final TipoGastoMapper tipoGastoMapper;

    public TipoGastoEditHandler(TipoGastoEditService tipoGastoEditService, TipoGastoMapper tipoGastoMapper) {
        this.tipoGastoEditService = tipoGastoEditService;
        this.tipoGastoMapper = tipoGastoMapper;
    }

    public void execute(UUID uuid, TipoGastoEditCommand editCommand) {

        var tipoGasto = tipoGastoMapper.fromUpdateDto(uuid, editCommand);

        tipoGastoEditService.execute(uuid, tipoGasto);

    }

}
