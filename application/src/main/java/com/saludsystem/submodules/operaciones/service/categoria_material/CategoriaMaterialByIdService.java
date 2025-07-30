package com.saludsystem.submodules.operaciones.service.categoria_material;

import com.saludsystem.submodules.operaciones.mapper.CategoriaMaterialMapper;
import com.saludsystem.submodules.operaciones.dtos.query.CategoriaMatDTO;
import com.saludsystem.submodules.operaciones.port.dao.CategoriaMaterialDao;

import java.util.UUID;

public class CategoriaMaterialByIdService {

    private final CategoriaMaterialDao categoriaMaterialDao;

    public CategoriaMaterialByIdService(CategoriaMaterialDao categoriaMaterialDao) {
        this.categoriaMaterialDao = categoriaMaterialDao;
    }

    public CategoriaMatDTO execute(UUID uuid) {
        return CategoriaMaterialMapper.toDto(categoriaMaterialDao.getById(uuid));
    }

}
