package com.saludsystem.submodules.catalogo.command.create;

import com.saludsystem.submodules.catalogo.mapper.CategoriaMapper;
import com.saludsystem.submodules.catalogo.model.dto.command.CategoriaCreateCommand;
import com.saludsystem.submodules.catalogo.service.categoria.CategoriaCreateService;
import org.springframework.stereotype.Component;

@Component
public class CategoriaCreateHandler {

    private final CategoriaCreateService categoriaCreateService;
    private final CategoriaMapper categoriaMapper;

    public CategoriaCreateHandler(CategoriaCreateService categoriaCreateService, CategoriaMapper categoriaMapper) {
        this.categoriaCreateService = categoriaCreateService;
        this.categoriaMapper = categoriaMapper;
    }

    public void execute(CategoriaCreateCommand dto) {

        var categoria = categoriaMapper.fromCreateDto(dto);

        categoriaCreateService.execute(categoria);

    }

}