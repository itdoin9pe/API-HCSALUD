package com.saludsystem.submodules.catalogo.service.categoria;

import com.saludsystem.submodules.catalogo.model.Categoria;
import com.saludsystem.submodules.catalogo.port.dao.CategoriaDao;
import com.saludsystem.submodules.catalogo.port.repository.CategoriaRepository;

import java.util.UUID;

public class CategoriaEditService {

    private final CategoriaDao categoriaDao;
    private final CategoriaRepository categoriaRepository;

    public CategoriaEditService(CategoriaDao categoriaDao, CategoriaRepository categoriaRepository) {
        this.categoriaDao = categoriaDao;
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria execute(UUID uuid, Categoria categoria) {

        var currentCategoria = categoriaDao.getById(uuid);

        if (currentCategoria.getEstado() != null && currentCategoria.getEstado() == 0) {
            throw new IllegalStateException("La categoria ya se encuentra desactivada");
        }

        return categoriaRepository.update(uuid, categoria);

    }

}
