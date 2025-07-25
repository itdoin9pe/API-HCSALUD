package com.saludsystem.submodules.movimiento.port.dao;

import com.saludsystem.submodules.movimiento.model.CompraDetalle;

import java.util.List;
import java.util.UUID;

public interface CompraDetalleService {

    CompraDetalle save(CompraDetalle compraDetalle);
    CompraDetalle update(UUID uuid, CompraDetalle compraDetalle);
    void delete(UUID uuid);
    CompraDetalle getById(UUID uuid);
    List<CompraDetalle> getAll(UUID hospitalId, int page, int rows);

}