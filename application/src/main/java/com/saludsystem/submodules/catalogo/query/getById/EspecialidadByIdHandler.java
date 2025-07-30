package com.saludsystem.submodules.catalogo.query.getById;

import com.saludsystem.submodules.catalogo.dto.EspecialidadDTO;
import com.saludsystem.submodules.catalogo.service.especialidad.EspecialidadByIdService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EspecialidadByIdHandler {

    private final EspecialidadByIdService especialidadByIdService;

    public EspecialidadByIdHandler(EspecialidadByIdService especialidadByIdService) {
        this.especialidadByIdService = especialidadByIdService;
    }

    public EspecialidadDTO execute(UUID uuid) {
        return especialidadByIdService.execute(uuid);
    }
}