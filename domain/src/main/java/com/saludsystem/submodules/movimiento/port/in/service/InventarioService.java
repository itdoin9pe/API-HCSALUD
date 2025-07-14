package com.saludsystem.submodules.movimiento.port.in.service;

import com.saludsystem.submodules.movimiento.model.Inventario;

import java.util.List;
import java.util.UUID;

public interface InventarioService {

    Inventario save(Inventario inventario);
    Inventario update(UUID uuid, Inventario inventario);
    void delete(UUID uuid);
    Inventario getById(UUID uuid);
    List<Inventario> getAll(UUID hospitalId, int page, int rows);

}