package com.saludsystem.submodules.operaciones.service.categoria_material;

import com.saludsystem.submodules.operaciones.mapper.CategoriaMaterialMapper;
import com.saludsystem.submodules.operaciones.model.dtos.get.CategoriaMatDTO;
import com.saludsystem.submodules.operaciones.port.dao.CategoriaMaterialDao;

import java.util.List;

public class CategoriaMaterialListService {

    private final CategoriaMaterialDao categoriaMaterialDao;

    public CategoriaMaterialListService(CategoriaMaterialDao categoriaMaterialDao) {
        this.categoriaMaterialDao = categoriaMaterialDao;
    }

    public List<CategoriaMatDTO> execute() {
        return categoriaMaterialDao.getList()
                .stream()
                .map(CategoriaMaterialMapper::toDto)
                .toList();
    }

}
