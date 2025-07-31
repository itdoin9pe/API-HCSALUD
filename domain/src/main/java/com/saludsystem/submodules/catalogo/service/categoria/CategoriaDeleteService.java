package com.saludsystem.submodules.catalogo.service.categoria;

import com.saludsystem.submodules.catalogo.port.dao.CategoriaDao;
import com.saludsystem.submodules.catalogo.port.repository.CategoriaRepository;

import java.util.UUID;

public class CategoriaDeleteService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaDao categoriaDao;

    public CategoriaDeleteService(CategoriaRepository categoriaRepository, CategoriaDao categoriaDao) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaDao = categoriaDao;
    }

    public void execute(UUID uuid) {

        var categoria = categoriaDao.getById(uuid);

        if (categoria.getEstado() != null && categoria.getEstado() == 0) {
            throw new IllegalStateException("No se puede eliminar una categoria ya desacativada");
        }

        categoriaRepository.delete(uuid);

    }

}