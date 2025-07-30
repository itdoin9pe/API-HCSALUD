package com.saludsystem.submodules.catalogo.query.getById;

import com.saludsystem.submodules.catalogo.model.dto.ApoderadoCreateCommand;
import com.saludsystem.submodules.catalogo.service.apoderado.ApoderadoByIdService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ApoderadoByIdHandler {

    private final ApoderadoByIdService apoderadoByIdService;

    public ApoderadoByIdHandler(ApoderadoByIdService apoderadoByIdService) {
        this.apoderadoByIdService = apoderadoByIdService;
    }

    public ApoderadoCreateCommand execute(UUID uuid) {
        return apoderadoByIdService.execute(uuid);
    }
}
