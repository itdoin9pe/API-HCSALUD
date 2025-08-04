package com.saludsystem.submodules.principal.command.edit;

import com.saludsystem.submodules.principal.mapper.EstudioMapper;
import com.saludsystem.submodules.principal.model.dtos.edit.EstudioEditCommand;
import com.saludsystem.submodules.principal.service.estudio.EstudioEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EstudioEditHandler {

    private final EstudioEditService estudioEditService;
    private final EstudioMapper estudioMapper;

    public EstudioEditHandler(EstudioEditService estudioEditService, EstudioMapper estudioMapper) {
        this.estudioEditService = estudioEditService;
        this.estudioMapper = estudioMapper;
    }

    public void execute(UUID uuid, EstudioEditCommand editCommand) {

        var estudioUpdated = estudioMapper.fromUpdateDto(uuid, editCommand);

        estudioEditService.execute(uuid, estudioUpdated);

    }

}
