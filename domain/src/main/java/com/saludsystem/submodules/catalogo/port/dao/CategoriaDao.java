package com.saludsystem.submodules.catalogo.port.dao;

import com.saludsystem.submodules.catalogo.model.Categoria;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface CategoriaDao {
    Categoria getById(UUID uuid);
    ListResponse<Categoria> getAll(UUID hospitalId, int page, int rows);
    List<Categoria> getList();
}