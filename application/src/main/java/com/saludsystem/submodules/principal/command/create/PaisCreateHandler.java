package com.saludsystem.submodules.principal.command.create;

import com.saludsystem.submodules.principal.mapper.PaisMapper;
import com.saludsystem.submodules.principal.model.dtos.command.PaisCreateCommand;
import com.saludsystem.submodules.principal.service.pais.PaisCreateService;
import org.springframework.stereotype.Component;

@Component
public class PaisCreateHandler {

    private final PaisCreateService paisCreateService;
    private final PaisMapper paisMapper;

    public PaisCreateHandler(PaisCreateService paisCreateService, PaisMapper paisMapper) {
        this.paisCreateService = paisCreateService;
        this.paisMapper = paisMapper;
    }

    public void execute(PaisCreateCommand createCommand) {

        var paisSaved = paisMapper.fromCreateDto(createCommand);

        paisCreateService.execute(paisSaved);

    }

}
