package com.saludsystem.domain.operaciones.port.in.service;

import com.saludsystem.domain.operaciones.model.CategoriaMaterial;

import java.util.List;
import java.util.UUID;

public interface CategoriaMatService {
    CategoriaMaterial save(CategoriaMaterial categoriaMaterial);
    CategoriaMaterial update(UUID uuid, CategoriaMaterial categoriaMaterial);
    void delete(UUID uuid);
    CategoriaMaterial getById(UUID uuid);
    List<CategoriaMaterial> getAll(UUID hospitalId, int page, int rows);
}