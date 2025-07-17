package com.saludsystem.submodules.catalogo.query.getAll;

import com.saludsystem.submodules.catalogo.model.dto.CategoriaDTO;
import com.saludsystem.submodules.catalogo.mapper.CategoriaMapper;
import com.saludsystem.submodules.catalogo.model.Categoria;
import com.saludsystem.submodules.catalogo.port.dao.CategoriaDao;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CategoriaAllHandler {

    private final CategoriaDao categoriaDao;

    public CategoriaAllHandler(CategoriaDao categoriaDao) {
        this.categoriaDao = categoriaDao;
    }

    public List<CategoriaDTO> execute(UUID hospitalId, int page, int rows) {
        List<Categoria> models = categoriaDao.getAll(hospitalId, page, rows);
        return models.stream().map(CategoriaMapper::toDto).toList();
    }
}
