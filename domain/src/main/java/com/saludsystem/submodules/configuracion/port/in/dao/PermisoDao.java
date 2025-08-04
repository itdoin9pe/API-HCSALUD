package com.saludsystem.submodules.configuracion.port.in.dao;

import com.saludsystem.submodules.configuracion.model.Permiso;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface PermisoDao {
    Permiso getById(UUID uuid);
    ListResponse<Permiso> getAll(UUID hospitalId, int page, int rows);
    List<Permiso> getList();
}
