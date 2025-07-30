package com.saludsystem.submodules.principal.query.getById;

import com.saludsystem.submodules.principal.dtos.get.AseguradoraDTO;
import com.saludsystem.submodules.principal.service.aseguradora.AseguradoraByIdService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AseguradoraByIdHandler {

    private final AseguradoraByIdService aseguradoraByIdService;

    public AseguradoraByIdHandler(AseguradoraByIdService aseguradoraByIdService) {
        this.aseguradoraByIdService = aseguradoraByIdService;
    }

    public AseguradoraDTO execute(UUID uuid) {
        return aseguradoraByIdService.execute(uuid);
    }

}
