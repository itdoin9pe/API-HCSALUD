package com.saludsystem.submodules.operaciones.port.repository;

import com.saludsystem.submodules.operaciones.model.Proveedor;

import java.util.UUID;

public interface ProveedorRepository {

    Proveedor save(Proveedor proveedor);
    Proveedor update(UUID uuid, Proveedor proveedor);
    void delete(UUID uuid);

}