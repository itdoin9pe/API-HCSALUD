package com.saludsystem.submodules.movimiento.port.dao;

import com.saludsystem.submodules.movimiento.model.Venta;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface VentaDao {

    Venta getById(UUID uuid);
    ListResponse<Venta> getAll(UUID hospitalId, int page, int rows);
    List<Venta> getList();

}