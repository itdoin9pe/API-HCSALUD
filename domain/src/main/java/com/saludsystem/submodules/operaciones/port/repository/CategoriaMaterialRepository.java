package com.saludsystem.submodules.operaciones.port.repository;

import com.saludsystem.submodules.operaciones.model.CategoriaMaterial;

import java.util.UUID;

public interface CategoriaMaterialRepository {
    CategoriaMaterial save(CategoriaMaterial categoriaMaterial);
    CategoriaMaterial update(UUID uuid, CategoriaMaterial categoriaMaterial);
    void delete(UUID uuid);
}