package com.saludsystem.submodules.catalogo.query.getById;

import com.saludsystem.submodules.catalogo.model.dto.EspecialidadCreateCommand;
import com.saludsystem.submodules.catalogo.service.especialidad.EspecialidadByIdService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EspecialidadByIdHandler {

    private final EspecialidadByIdService especialidadByIdService;

    public EspecialidadByIdHandler(EspecialidadByIdService especialidadByIdService) {
        this.especialidadByIdService = especialidadByIdService;
    }

    public EspecialidadCreateCommand execute(UUID uuid) {
        return especialidadByIdService.execute(uuid);
    }
}