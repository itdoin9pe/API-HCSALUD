package com.saludsystem.submodules.catalogo.command.delete;

import com.saludsystem.submodules.catalogo.service.categoria.CategoriaDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CategoriaDeleteHandler {

    private final CategoriaDeleteService categoriaDeleteService;

    public CategoriaDeleteHandler(CategoriaDeleteService categoriaDeleteService) {
        this.categoriaDeleteService = categoriaDeleteService;
    }

    public void execute(UUID uuid) {
        categoriaDeleteService.execute(uuid);
    }
}