package com.saludsystem.submodules.operaciones.port.dao;

import com.saludsystem.submodules.operaciones.model.Unidad;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface UnidadDao {

    Unidad getById(UUID uuid);
    ListResponse<Unidad> getAll(UUID hospitalId, int page, int rows);
    List<Unidad> getList();

}