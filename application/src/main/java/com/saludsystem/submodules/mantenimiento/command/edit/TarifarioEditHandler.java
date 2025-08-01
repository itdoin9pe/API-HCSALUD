package com.saludsystem.submodules.mantenimiento.command.edit;

import com.saludsystem.submodules.mantenimiento.mapper.TarifarioMapper;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.edit.TarifarioEditCommand;
import com.saludsystem.submodules.mantenimiento.service.tarifario.TarifarioEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TarifarioEditHandler {

    private final TarifarioEditService tarifarioEditService;
    private final TarifarioMapper tarifarioMapper;

    public TarifarioEditHandler(TarifarioEditService tarifarioEditService, TarifarioMapper tarifarioMapper) {
        this.tarifarioEditService = tarifarioEditService;
        this.tarifarioMapper = tarifarioMapper;
    }

    public void execute(UUID uuid, TarifarioEditCommand editCommand) {

        var tarifario = tarifarioMapper.fromUpdateDto(uuid, editCommand);

        tarifarioEditService.execute(uuid, tarifario);

    }

}
