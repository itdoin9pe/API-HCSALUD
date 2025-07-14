package com.saludsystem.submodules.catalogo.port.in.service;

import com.saludsystem.submodules.catalogo.model.Categoria;

import java.util.List;
import java.util.UUID;

public interface CategoriaService {
    Categoria save(Categoria categoria);
    Categoria update(UUID uuid, Categoria categoria);
    void delete(UUID uuid);
    Categoria getById(UUID uuid);
    List<Categoria> getAll(UUID hospitalId, int page, int rows);
}