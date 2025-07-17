package com.saludsystem.submodules.catalogo.command.create;

import com.saludsystem.submodules.catalogo.model.dto.command.CrearCategoriaDTO;
import com.saludsystem.submodules.catalogo.mapper.CategoriaMapper;
import com.saludsystem.submodules.catalogo.port.dao.CategoriaDao;
import org.springframework.stereotype.Component;

@Component
public class CategoriaCreateHandler {

    private final CategoriaDao categoriaDao;

    public CategoriaCreateHandler(CategoriaDao categoriaDao) {
        this.categoriaDao = categoriaDao;
    }

    public void execute(CrearCategoriaDTO dto) {
        categoriaDao.save(CategoriaMapper.fromCreateDto(dto));
    }
}