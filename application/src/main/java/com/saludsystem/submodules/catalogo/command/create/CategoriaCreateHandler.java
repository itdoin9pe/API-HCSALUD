package com.saludsystem.submodules.catalogo.command.create;

import com.saludsystem.submodules.catalogo.model.dto.command.CategoriaCreateCommand;
import com.saludsystem.submodules.catalogo.service.categoria.CategoriaCreateService;
import org.springframework.stereotype.Component;

@Component
public class CategoriaCreateHandler {

    private final CategoriaCreateService categoriaCreateService;

    public CategoriaCreateHandler(CategoriaCreateService categoriaCreateService) {
        this.categoriaCreateService = categoriaCreateService;
    }

    public void execute(CategoriaCreateCommand dto) {
        categoriaCreateService.execute(dto);
    }
}