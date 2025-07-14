package com.saludsystem.submodules.operaciones.port.in.service;

import com.saludsystem.submodules.operaciones.model.Proveedor;

import java.util.List;
import java.util.UUID;

public interface ProveedorService {
    Proveedor save(Proveedor proveedor);
    Proveedor update(UUID uuid, Proveedor proveedor);
    void delete(UUID uuid);
    Proveedor getById(UUID uuid);
    List<Proveedor> getAll(UUID hospitalId, int page, int rows);
}