package com.saludsystem.submodules.principal.port.dao;

import com.saludsystem.submodules.principal.model.Sucursal;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface SucursalDao {

    Sucursal getById(UUID uuid);
    ListResponse<Sucursal> getAll(UUID hospitalId, int page, int rows);
    List<Sucursal> getList();

}
