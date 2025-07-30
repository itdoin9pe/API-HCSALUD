package com.saludsystem.submodules.catalogo.command.edit;

import com.saludsystem.submodules.catalogo.dto.edit.ActualizarCategoriaDTO;
import com.saludsystem.submodules.catalogo.service.categoria.CategoriaEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CategoriaEditHandler {

    private final CategoriaEditService categoriaEditService;

    public CategoriaEditHandler(CategoriaEditService categoriaEditService) {
        this.categoriaEditService = categoriaEditService;
    }

    public void execute(UUID uuid, ActualizarCategoriaDTO dto) {
        categoriaEditService.execute(uuid, dto);
    }
}
