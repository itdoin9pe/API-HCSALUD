package com.saludsystem.submodules.catalogo.query.getById;

import com.saludsystem.submodules.catalogo.dto.CategoriaDTO;
import com.saludsystem.submodules.catalogo.service.categoria.CategoriaByIdService;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
public class CategoriaByIdHandler {

    private final CategoriaByIdService byIdService;

    public CategoriaByIdHandler(CategoriaByIdService byIdService) {
        this.byIdService = byIdService;
    }

    public CategoriaDTO execute(UUID uuid) {
        return byIdService.execute(uuid);
    }
}