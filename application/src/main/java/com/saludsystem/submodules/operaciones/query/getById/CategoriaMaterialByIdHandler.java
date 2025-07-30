package com.saludsystem.submodules.operaciones.query.getById;

import com.saludsystem.submodules.operaciones.dtos.query.CategoriaMatDTO;
import com.saludsystem.submodules.operaciones.service.categoria_material.CategoriaMaterialByIdService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CategoriaMaterialByIdHandler {

    private final CategoriaMaterialByIdService categoriaMaterialByIdService;

    public CategoriaMaterialByIdHandler(CategoriaMaterialByIdService categoriaMaterialByIdService) {
        this.categoriaMaterialByIdService = categoriaMaterialByIdService;
    }

    public CategoriaMatDTO execute(UUID uuid) {
        return categoriaMaterialByIdService.execute(uuid);
    }

}
