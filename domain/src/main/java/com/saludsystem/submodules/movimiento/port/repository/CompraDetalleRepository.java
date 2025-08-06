package com.saludsystem.submodules.movimiento.port.repository;

import com.saludsystem.submodules.movimiento.model.CompraDetalle;

import java.util.UUID;

public interface CompraDetalleRepository {
    CompraDetalle save(CompraDetalle compraDetalle);
    CompraDetalle update(UUID uuid, CompraDetalle compraDetalle);
    void delete(UUID uuid);
}