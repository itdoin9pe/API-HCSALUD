package com.saludsystem.submodules.configuracion.command.edit;

import com.saludsystem.submodules.configuracion.mapper.PermisoMapper;
import com.saludsystem.submodules.configuracion.model.dtos.command.edit.PermisoEditCommand;
import com.saludsystem.submodules.configuracion.service.permiso.PermisoEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PermisoEditHandler {

    private final PermisoEditService permisoEditService;
    private final PermisoMapper permisoMapper;

    public PermisoEditHandler(PermisoEditService permisoEditService, PermisoMapper permisoMapper) {
        this.permisoEditService = permisoEditService;
        this.permisoMapper = permisoMapper;
    }

    public void execute(UUID uuid, PermisoEditCommand editCommand) {

        var permisoUpdated = permisoMapper.fromUpdateDto(uuid, editCommand);

        permisoEditService.execute(uuid, permisoUpdated);

    }

}
