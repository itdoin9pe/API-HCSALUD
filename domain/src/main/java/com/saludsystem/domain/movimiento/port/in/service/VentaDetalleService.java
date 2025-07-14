package com.saludsystem.domain.movimiento.port.in.service;

import com.saludsystem.domain.movimiento.model.VentaDetalle;

import java.util.List;
import java.util.UUID;

public interface VentaDetalleService {

    VentaDetalle save(VentaDetalle ventaDetalle);
    VentaDetalle update(UUID uuid, VentaDetalle ventaDetalle);
    void delete(UUID uuid);
    VentaDetalle getById(UUID uuid);
    List<VentaDetalle> getAll(UUID hospitalId, int page, int rows);
}