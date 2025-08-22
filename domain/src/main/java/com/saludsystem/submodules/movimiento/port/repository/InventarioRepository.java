package com.saludsystem.submodules.movimiento.port.repository;

import com.saludsystem.submodules.movimiento.model.Inventario;

import java.util.UUID;

public interface InventarioRepository {

    Inventario save(Inventario inventario);

    Inventario update(UUID uuid, Inventario inventario);

    void delete(UUID uuid);

}