package com.saludsystem.submodules.catalogo.service.categoria;

import com.saludsystem.submodules.catalogo.mapper.CategoriaMapper;
import com.saludsystem.submodules.catalogo.model.dto.CategoriaCreateCommand;
import com.saludsystem.submodules.catalogo.port.dao.CategoriaDao;

import java.util.UUID;

public class CategoriaByIdService {

    private final CategoriaDao categoriaDao;

    public CategoriaByIdService(CategoriaDao categoriaDao) {
        this.categoriaDao = categoriaDao;
    }

    public CategoriaCreateCommand execute(UUID uuid) {
        return CategoriaMapper.toDto(categoriaDao.getById(uuid));
    }

}