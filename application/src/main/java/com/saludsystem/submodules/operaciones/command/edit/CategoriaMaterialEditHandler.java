package com.saludsystem.submodules.operaciones.command.edit;

import com.saludsystem.submodules.operaciones.dtos.edit.ActualizarCategoriaMatDTO;
import com.saludsystem.submodules.operaciones.service.categoria_material.CategoriaMaterialEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CategoriaMaterialEditHandler {

    private final CategoriaMaterialEditService categoriaMaterialEditService;

    public CategoriaMaterialEditHandler(CategoriaMaterialEditService categoriaMaterialEditService) {
        this.categoriaMaterialEditService = categoriaMaterialEditService;
    }

    public void execute(UUID uuid, ActualizarCategoriaMatDTO dto) {
        categoriaMaterialEditService.execute(uuid, dto);
    }

}
