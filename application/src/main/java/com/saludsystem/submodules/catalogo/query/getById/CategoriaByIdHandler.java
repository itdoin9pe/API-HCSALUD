package com.saludsystem.submodules.catalogo.query.getById;

import com.saludsystem.submodules.catalogo.dtos.get.CategoriaDTO;
import com.saludsystem.submodules.catalogo.mapper.CategoriaMapper;
import com.saludsystem.submodules.catalogo.model.Categoria;
import com.saludsystem.submodules.catalogo.port.in.service.CategoriaService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CategoriaByIdHandler {

    private final CategoriaService categoriaService;

    public CategoriaByIdHandler(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    public CategoriaDTO execute(UUID uuid){
        Categoria model = categoriaService.getById(uuid);
        return CategoriaMapper.toDto(model);
    }
}