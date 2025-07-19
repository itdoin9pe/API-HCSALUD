package com.saludsystem.submodules.catalogo.command.delete;

import com.saludsystem.submodules.catalogo.service.especialidad.EspecialidadDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EspecialidadDeleteHandler {

    private final EspecialidadDeleteService especialidadDeleteService;

    public EspecialidadDeleteHandler(EspecialidadDeleteService especialidadDeleteService) {
        this.especialidadDeleteService = especialidadDeleteService;
    }

    public void execute(UUID uuid) {
        especialidadDeleteService.execute(uuid);
    }
}