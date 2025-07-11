package com.saludsystem.domain.catalogo.port.out.repository;

import com.saludsystem.domain.catalogo.model.Categoria;

import java.util.List;
import java.util.UUID;

public interface CategoriaRepositoryPort {
    Categoria save(Categoria categoria);
    Categoria update(UUID uuid, Categoria categoria);
    void delete(UUID uuid);
    Categoria findById(UUID uuid);
    List<Categoria> findAll(UUID hospitalId, int page, int rows);
}