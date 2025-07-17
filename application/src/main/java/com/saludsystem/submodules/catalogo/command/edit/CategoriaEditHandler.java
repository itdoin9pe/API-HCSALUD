package com.saludsystem.submodules.catalogo.command.edit;

import com.saludsystem.submodules.catalogo.model.dto.edit.ActualizarCategoriaDTO;
import com.saludsystem.submodules.catalogo.mapper.CategoriaMapper;
import com.saludsystem.submodules.catalogo.port.dao.CategoriaDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CategoriaEditHandler {

    private final CategoriaDao categoriaDao;

    public CategoriaEditHandler(CategoriaDao categoriaDao) {
        this.categoriaDao = categoriaDao;
    }

    public void execute(UUID uuid, ActualizarCategoriaDTO dto) {
        categoriaDao.update(uuid, CategoriaMapper.fromUpdateDto(uuid, dto));
    }
}
