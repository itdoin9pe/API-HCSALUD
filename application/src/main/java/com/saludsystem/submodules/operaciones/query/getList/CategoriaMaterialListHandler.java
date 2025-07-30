package com.saludsystem.submodules.operaciones.query.getList;

import com.saludsystem.submodules.operaciones.dtos.query.CategoriaMatDTO;
import com.saludsystem.submodules.operaciones.service.categoria_material.CategoriaMaterialListService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriaMaterialListHandler {

    private final CategoriaMaterialListService categoriaMaterialListService;

    public CategoriaMaterialListHandler(CategoriaMaterialListService categoriaMaterialListService) {
        this.categoriaMaterialListService = categoriaMaterialListService;
    }

    public List<CategoriaMatDTO> execute(){
        return categoriaMaterialListService.execute();
    }

}
