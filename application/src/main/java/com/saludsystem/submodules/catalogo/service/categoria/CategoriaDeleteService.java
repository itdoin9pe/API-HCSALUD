package com.saludsystem.submodules.catalogo.service.categoria;

import com.saludsystem.submodules.catalogo.port.repository.CategoriaRepository;

import java.util.UUID;

public class CategoriaDeleteService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaDeleteService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public void execute(UUID uuid) {
        categoriaRepository.delete(uuid);
    }

}