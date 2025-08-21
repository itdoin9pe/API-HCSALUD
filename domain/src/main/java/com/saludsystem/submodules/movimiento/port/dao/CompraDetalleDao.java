package com.saludsystem.submodules.movimiento.port.dao;

import com.saludsystem.submodules.movimiento.model.CompraDetalle;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface CompraDetalleDao {

    CompraDetalle getById(UUID uuid);

    ListResponse<CompraDetalle> getAll(UUID hospitalId, int page, int rows);

    List<CompraDetalle> getList();

}