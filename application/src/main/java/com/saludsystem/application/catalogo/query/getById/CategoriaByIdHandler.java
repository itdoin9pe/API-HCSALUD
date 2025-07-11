package com.saludsystem.application.catalogo.query.getById;

import com.saludsystem.application.catalogo.dtos.get.CategoriaDTO;
import com.saludsystem.application.catalogo.mapper.CategoriaMapper;
import com.saludsystem.domain.catalogo.model.Categoria;
import com.saludsystem.domain.catalogo.port.in.service.CategoriaService;
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