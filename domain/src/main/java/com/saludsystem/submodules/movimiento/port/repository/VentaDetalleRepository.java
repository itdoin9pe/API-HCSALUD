package com.saludsystem.submodules.movimiento.port.repository;

import com.saludsystem.submodules.movimiento.model.VentaDetalle;

import java.util.UUID;

public interface VentaDetalleRepository {
    VentaDetalle save(VentaDetalle ventaDetalle);
    VentaDetalle update(UUID uuid, VentaDetalle ventaDetalle);
    void delete(UUID uuid);
}