package com.saludsystem.submodules.operaciones.port.dao;

import com.saludsystem.submodules.operaciones.model.TipoMaterial;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface TipoMaterialDao {

    TipoMaterial getById(UUID uuid);
    ListResponse<TipoMaterial> getAll(UUID hospitalId, int page, int rows);
    List<TipoMaterial> getList();

}