package com.saludsystem.submodules.operaciones.port.dao;

import com.saludsystem.submodules.operaciones.model.TipoMaterial;

import java.util.List;
import java.util.UUID;

public interface TipoMaterialDao {
    TipoMaterial save(TipoMaterial tipoMaterial);
    TipoMaterial update(UUID uuid, TipoMaterial tipoMaterial);
    void delete(UUID uuid);
    TipoMaterial getById(UUID uuid);
    List<TipoMaterial> getAll(UUID hospitalId, int page, int rows);
}