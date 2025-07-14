package com.saludsystem.submodules.catalogo.query.getAll;

import com.saludsystem.submodules.catalogo.dtos.get.CategoriaDTO;
import com.saludsystem.submodules.catalogo.mapper.CategoriaMapper;
import com.saludsystem.submodules.catalogo.model.Categoria;
import com.saludsystem.submodules.catalogo.port.in.service.CategoriaService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CategoriaAllHandler {

    private final CategoriaService categoriaService;

    public CategoriaAllHandler(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    public List<CategoriaDTO> execute(UUID hospitalId, int page, int rows) {
        List<Categoria> models = categoriaService.getAll(hospitalId, page, rows);
        return models.stream().map(CategoriaMapper::toDto).toList();
    }
}
