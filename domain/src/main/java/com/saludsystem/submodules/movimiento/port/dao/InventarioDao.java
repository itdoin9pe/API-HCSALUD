package com.saludsystem.submodules.movimiento.port.dao;

import com.saludsystem.submodules.movimiento.model.Inventario;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface InventarioDao {

    Inventario getById(UUID uuid);
    ListResponse<Inventario> getAll(UUID hospitalId, int page, int rows);
    List<Inventario> getList();

}