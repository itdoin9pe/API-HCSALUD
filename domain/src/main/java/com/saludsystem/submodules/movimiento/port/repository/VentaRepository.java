package com.saludsystem.submodules.movimiento.port.repository;

import com.saludsystem.submodules.movimiento.model.Venta;

import java.util.UUID;

public interface VentaRepository {

    Venta save(Venta venta);

    Venta update(UUID uuid, Venta venta);

    void delete(UUID uuid);

}