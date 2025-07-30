package com.saludsystem.submodules.catalogo.service.categoria;

import com.saludsystem.submodules.catalogo.mapper.CategoriaMapper;
import com.saludsystem.submodules.catalogo.dto.CategoriaDTO;
import com.saludsystem.submodules.catalogo.port.dao.CategoriaDao;

import java.util.List;

public class CategoriaListService {

    private final CategoriaDao categoriaDao;

    public CategoriaListService(CategoriaDao categoriaDao) {
        this.categoriaDao = categoriaDao;
    }

    public List<CategoriaDTO> execute() {
        return categoriaDao.getList().stream().map(CategoriaMapper::toDto).toList();
    }

}