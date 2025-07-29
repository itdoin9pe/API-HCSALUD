package com.saludsystem.submodules.operaciones.port.dao;

import com.saludsystem.submodules.operaciones.model.CategoriaMaterial;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface CategoriaMaterialDao {
    CategoriaMaterial getById(UUID uuid);
    ListResponse<CategoriaMaterial> getAll(UUID hospitalId, int page, int rows);
    List<CategoriaMaterial> getList();
}