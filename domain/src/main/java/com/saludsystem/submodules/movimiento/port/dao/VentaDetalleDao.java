package com.saludsystem.submodules.movimiento.port.dao;

import com.saludsystem.submodules.movimiento.model.VentaDetalle;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface VentaDetalleDao {
    VentaDetalle getById(UUID uuid);
    ListResponse<VentaDetalle> getAll(UUID hospitalId, int page, int rows);
    List<VentaDetalle> getList();
}