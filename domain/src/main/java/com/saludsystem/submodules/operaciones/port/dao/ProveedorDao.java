package com.saludsystem.submodules.operaciones.port.dao;

import com.saludsystem.submodules.operaciones.model.Proveedor;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface ProveedorDao {
    Proveedor getById(UUID uuid);
    ListResponse<Proveedor> getAll(UUID hospitalId, int page, int rows);
    List<Proveedor> getList();
}