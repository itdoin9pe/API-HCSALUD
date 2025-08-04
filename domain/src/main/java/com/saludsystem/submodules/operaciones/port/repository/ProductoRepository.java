package com.saludsystem.submodules.operaciones.port.repository;

import com.saludsystem.submodules.operaciones.model.Producto;

import java.util.UUID;

public interface ProductoRepository {

    Producto save(Producto producto);
    Producto update(UUID uuid, Producto producto);
    void delete(UUID uuid);

}
