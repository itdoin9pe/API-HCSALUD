package com.saludsystem.submodules.operaciones.port.dao;

import com.saludsystem.submodules.operaciones.model.Producto;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface ProductoDao {

    Producto getById(UUID uuid);
    ListResponse<Producto> getAll(UUID hospitalId, int page, int rows);
    List<Producto> getList();

}