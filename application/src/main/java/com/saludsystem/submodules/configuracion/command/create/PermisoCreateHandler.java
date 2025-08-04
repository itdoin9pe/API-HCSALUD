package com.saludsystem.submodules.configuracion.command.create;

import com.saludsystem.submodules.configuracion.mapper.PermisoMapper;
import com.saludsystem.submodules.configuracion.model.dtos.command.PermisoCreateCommand;
import com.saludsystem.submodules.configuracion.service.permiso.PermisoCreateService;
import org.springframework.stereotype.Component;

@Component
public class PermisoCreateHandler {

    private final PermisoCreateService permisoCreateService;
    private final PermisoMapper permisoMapper;

    public PermisoCreateHandler(PermisoCreateService permisoCreateService, PermisoMapper permisoMapper) {
        this.permisoCreateService = permisoCreateService;
        this.permisoMapper = permisoMapper;
    }

    public void execute(PermisoCreateCommand createCommand) {

        var permisoSaved = permisoMapper.fromCreateDto(createCommand);

        permisoCreateService.execute(permisoSaved);

    }

}
