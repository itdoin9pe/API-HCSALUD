package com.saludsystem.submodules.operaciones.port.dao;

import com.saludsystem.submodules.operaciones.model.Proveedor;

import java.util.List;
import java.util.UUID;

public interface ProveedorDao {
    Proveedor save(Proveedor proveedor);
    Proveedor update(UUID uuid, Proveedor proveedor);
    void delete(UUID uuid);
    Proveedor getById(UUID uuid);
    List<Proveedor> getAll(UUID hospitalId, int page, int rows);
}