package com.saludsystem.submodules.movimiento.port.dao;

import com.saludsystem.submodules.movimiento.model.Compra;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface CompraDao {

    Compra getById(UUID uuid);

    ListResponse<Compra> getAll(UUID hospitalId, int page, int rows);

    List<Compra> getList();

}