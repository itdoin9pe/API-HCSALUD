package com.saludsystem.application.catalogo.command.delete;

import com.saludsystem.domain.catalogo.port.in.service.CategoriaService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CategoriaDeleteHandler {

    private final CategoriaService categoriaService;

    public CategoriaDeleteHandler(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    public void execute(UUID uuid){
        categoriaService.delete(uuid);
    }
}