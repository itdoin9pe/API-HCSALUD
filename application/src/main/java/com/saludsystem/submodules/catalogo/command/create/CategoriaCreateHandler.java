package com.saludsystem.submodules.catalogo.command.create;

import com.saludsystem.submodules.catalogo.dtos.post.CrearCategoriaDTO;
import com.saludsystem.submodules.catalogo.mapper.CategoriaMapper;
import com.saludsystem.submodules.catalogo.port.in.service.CategoriaService;
import org.springframework.stereotype.Component;

@Component
public class CategoriaCreateHandler {

    private final CategoriaService categoriaService;

    public CategoriaCreateHandler(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    public void execute(CrearCategoriaDTO dto) {
        categoriaService.save(CategoriaMapper.fromCreateDto(dto));
    }
}