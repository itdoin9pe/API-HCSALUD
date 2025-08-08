package com.saludsystem.submodules.principal.command.edit;

import com.saludsystem.submodules.principal.mapper.PaisMapper;
import com.saludsystem.submodules.principal.model.dtos.command.edit.PaisEditCommand;
import com.saludsystem.submodules.principal.service.pais.PaisEditService;
import org.springframework.stereotype.Component;

@Component
public class PaisEditHandler {

    private final PaisEditService paisEditService;
    private final PaisMapper paisMapper;

    public PaisEditHandler(PaisEditService paisEditService, PaisMapper paisMapper) {
        this.paisEditService = paisEditService;
        this.paisMapper = paisMapper;
    }

    public void execute(Integer id, PaisEditCommand editCommand) {

        var paisUpdate = paisMapper.fromUpdateDto(id, editCommand);

        paisEditService.execute(id, paisUpdate);

    }

}
