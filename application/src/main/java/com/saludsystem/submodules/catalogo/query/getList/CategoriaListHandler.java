package com.saludsystem.submodules.catalogo.query.getList;

import com.saludsystem.submodules.catalogo.dto.CategoriaDTO;
import com.saludsystem.submodules.catalogo.service.categoria.CategoriaListService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriaListHandler {

    private final CategoriaListService categoriaListService;

    public CategoriaListHandler(CategoriaListService categoriaListService) {
        this.categoriaListService = categoriaListService;
    }

    public List<CategoriaDTO> execute() {
        return categoriaListService.execute();
    }
}
