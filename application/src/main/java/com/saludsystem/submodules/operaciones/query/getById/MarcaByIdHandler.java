package com.saludsystem.submodules.operaciones.query.getById;

import com.saludsystem.submodules.operaciones.dtos.query.MarcaDTO;
import com.saludsystem.submodules.operaciones.service.marca.MarcaByIdService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MarcaByIdHandler {

    private final MarcaByIdService marcaByIdService;

    public MarcaByIdHandler(MarcaByIdService marcaByIdService) {
        this.marcaByIdService = marcaByIdService;
    }

    public MarcaDTO execute(UUID uuid) {
        return marcaByIdService.execute(uuid);
    }

}
