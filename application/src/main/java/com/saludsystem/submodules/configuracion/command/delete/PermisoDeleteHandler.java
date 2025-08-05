package com.saludsystem.submodules.configuracion.command.delete;

import com.saludsystem.submodules.configuracion.service.permiso.PermisoDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PermisoDeleteHandler {

    private final PermisoDeleteService permisoDeleteService;

    public PermisoDeleteHandler(PermisoDeleteService permisoDeleteService) {
        this.permisoDeleteService = permisoDeleteService;
    }

    public void execute(UUID uuid) {

        permisoDeleteService.execute(uuid);

    }

}
