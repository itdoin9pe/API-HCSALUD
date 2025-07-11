package com.saludsystem.application.catalogo.command.create;

import com.saludsystem.application.catalogo.dtos.post.CrearCategoriaDTO;
import com.saludsystem.application.catalogo.mapper.CategoriaMapper;
import com.saludsystem.domain.catalogo.port.in.service.CategoriaService;
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