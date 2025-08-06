package com.saludsystem.submodules.movimiento.port.repository;

import com.saludsystem.submodules.movimiento.model.Almacen;

import java.util.UUID;

public interface AlmacenRepository {
    Almacen save(Almacen almacen);
    Almacen update(UUID uuid, Almacen almacen);
    void delete(UUID uuid);
}