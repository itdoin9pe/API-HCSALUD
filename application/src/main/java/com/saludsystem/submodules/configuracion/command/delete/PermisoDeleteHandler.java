package com.saludsystem.submodules.configuracion.command.delete;

import com.saludsystem.submodules.configuracion.mapper.PermisoMapper;
import com.saludsystem.submodules.configuracion.service.permiso.PermisoDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PermisoDeleteHandler {

    private final PermisoDeleteService permisoDeleteService;
    private final PermisoMapper permisoMapper;

    public PermisoDeleteHandler(PermisoDeleteService permisoDeleteService, PermisoMapper permisoMapper) {
        this.permisoDeleteService = permisoDeleteService;
        this.permisoMapper = permisoMapper;
    }

    public void execute(UUID uuid) {

        permisoDeleteService.execute(uuid);

    }

}
