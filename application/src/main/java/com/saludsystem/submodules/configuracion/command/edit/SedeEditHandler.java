package com.saludsystem.submodules.configuracion.command.edit;

import com.saludsystem.submodules.configuracion.mapper.SedeMapper;
import com.saludsystem.submodules.configuracion.model.dtos.command.edit.SedeEditCommand;
import com.saludsystem.submodules.configuracion.service.sede.SedeEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SedeEditHandler {

    private final SedeEditService sedeEditService;
    private final SedeMapper sedeMapper;

    public SedeEditHandler(SedeEditService sedeEditService, SedeMapper sedeMapper) {
        this.sedeEditService = sedeEditService;
        this.sedeMapper = sedeMapper;
    }

    public void execute(UUID uuid, SedeEditCommand editCommand) {

        var sedeUpdated = sedeMapper.fromUpdateDto(uuid, editCommand);

        sedeEditService.execute(uuid, sedeUpdated);

    }

}
