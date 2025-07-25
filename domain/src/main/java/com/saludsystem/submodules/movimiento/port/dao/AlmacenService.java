package com.saludsystem.submodules.movimiento.port.dao;

import com.saludsystem.submodules.movimiento.model.Almacen;

import java.util.List;
import java.util.UUID;

public interface AlmacenService {
    Almacen save(Almacen tipoCitado);
    Almacen update(UUID uuid, Almacen tipoCitado);
    void delete(UUID uuid);
    Almacen getById(UUID uuid);
    List<Almacen> getAll(UUID hospitalId, int page, int rows);
}