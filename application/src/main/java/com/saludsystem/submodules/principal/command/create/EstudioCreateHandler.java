package com.saludsystem.submodules.principal.command.create;

import com.saludsystem.submodules.principal.mapper.EstudioMapper;
import com.saludsystem.submodules.principal.model.dtos.command.EstudioCreateCommand;
import com.saludsystem.submodules.principal.service.estudio.EstudioCreateService;
import org.springframework.stereotype.Component;

@Component
public class EstudioCreateHandler {

    private final EstudioCreateService estudioCreateService;
    private final EstudioMapper estudioMapper;

    public EstudioCreateHandler(EstudioCreateService estudioCreateService, EstudioMapper estudioMapper) {
        this.estudioCreateService = estudioCreateService;
        this.estudioMapper = estudioMapper;
    }

    public void execute(EstudioCreateCommand createCommand) {

        var estudioSave = estudioMapper.fromCreateDto(createCommand);

        estudioCreateService.execute(estudioSave);

    }

}
