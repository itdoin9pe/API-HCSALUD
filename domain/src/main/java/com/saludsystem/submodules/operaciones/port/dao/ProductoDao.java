package com.saludsystem.submodules.operaciones.port.dao;

import com.saludsystem.submodules.operaciones.model.Producto;

import java.util.List;
import java.util.UUID;

public interface ProductoDao {

    Producto save(Producto producto);
    Producto update(UUID uuid, Producto producto);
    void delete(UUID uuid);
    Producto getById(UUID uuid);
    List<Producto> getAll(UUID hospitalId, int page, int rows);

}