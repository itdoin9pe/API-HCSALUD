package com.saludsystem.submodules.catalogo.query.getById;

import com.saludsystem.submodules.catalogo.model.dto.CategoriaDTO;
import com.saludsystem.submodules.catalogo.mapper.CategoriaMapper;
import com.saludsystem.submodules.catalogo.model.Categoria;
import com.saludsystem.submodules.catalogo.port.dao.CategoriaDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CategoriaByIdHandler {

    private final CategoriaDao categoriaDao;

    public CategoriaByIdHandler(CategoriaDao categoriaDao) {
        this.categoriaDao = categoriaDao;
    }

    public CategoriaDTO execute(UUID uuid){
        Categoria model = categoriaDao.getById(uuid);
        return CategoriaMapper.toDto(model);
    }
}