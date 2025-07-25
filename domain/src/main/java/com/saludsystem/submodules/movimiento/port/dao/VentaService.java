package com.saludsystem.submodules.movimiento.port.dao;

import com.saludsystem.submodules.movimiento.model.Venta;

import java.util.List;
import java.util.UUID;

public interface VentaService {

    Venta save(Venta venta);
    Venta update(UUID uuid, Venta venta);
    void delete(UUID uuid);
    Venta getById(UUID uuid);
    List<Venta> getAll(UUID hospitalId, int page, int rows);

}