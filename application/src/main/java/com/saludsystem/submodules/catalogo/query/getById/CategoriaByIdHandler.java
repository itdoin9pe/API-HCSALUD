package com.saludsystem.submodules.catalogo.query.getById;

import com.saludsystem.submodules.catalogo.mapper.CategoriaMapper;
import com.saludsystem.submodules.catalogo.model.constant.CategoriaConstant;
import com.saludsystem.submodules.catalogo.model.dto.CategoriaDTO;
import com.saludsystem.submodules.catalogo.port.dao.CategoriaDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CategoriaByIdHandler {

    private final CategoriaDao categoriaDao;
    private final CategoriaMapper categoriaMapper;

    public CategoriaByIdHandler(CategoriaDao categoriaDao, CategoriaMapper categoriaMapper) {
        this.categoriaDao = categoriaDao;
        this.categoriaMapper = categoriaMapper;
    }

    public CategoriaDTO execute(UUID uuid) {

        var categoria = categoriaDao.getById(uuid);

        if (categoria == null) {

            throw new IllegalArgumentException(CategoriaConstant.ID_INVALID);

        }

        return categoriaMapper.toDto(categoria);

    }

}