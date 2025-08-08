package com.saludsystem.submodules.configuracion.command.edit;

import com.saludsystem.submodules.configuracion.mapper.RolMapper;
import com.saludsystem.submodules.configuracion.model.dtos.command.edit.RolEditCommand;
import com.saludsystem.submodules.configuracion.service.rol.RolEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RolEditHandler {

    private final RolEditService rolEditService;
    private final RolMapper rolMapper;

    public RolEditHandler(RolEditService rolEditService, RolMapper rolMapper) {
        this.rolEditService = rolEditService;
        this.rolMapper = rolMapper;
    }

    public void execute(UUID uuid, RolEditCommand editCommand) {

        var rolUpdated = rolMapper.fromUpdateDto(uuid, editCommand);

        rolEditService.execute(uuid, rolUpdated);

    }

}
