package com.saludsystem.application.catalogo.command.delete;

import com.saludsystem.domain.catalogo.port.in.service.EspecialidadService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EspecialidadDeleteHandler {
    private final EspecialidadService especialidadService;

    public EspecialidadDeleteHandler(EspecialidadService especialidadService) {
        this.especialidadService = especialidadService;
    }

    public void execute(UUID uuid){
        especialidadService.delete(uuid);
    }
}