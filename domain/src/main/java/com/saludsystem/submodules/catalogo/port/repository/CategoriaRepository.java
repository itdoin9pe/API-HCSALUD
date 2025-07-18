package com.saludsystem.submodules.catalogo.port.repository;

import com.saludsystem.submodules.catalogo.model.Categoria;

import java.util.UUID;

public interface CategoriaRepository {
    Categoria save(Categoria categoria);
    Categoria update(UUID uuid, Categoria categoria);
    void delete(UUID uuid);
}