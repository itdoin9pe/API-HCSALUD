package com.saludsystem.domain.operaciones.port.in.service;

import com.saludsystem.domain.operaciones.model.Producto;

import java.util.List;
import java.util.UUID;

public interface ProductoService {

    Producto save(Producto producto);
    Producto update(UUID uuid, Producto producto);
    void delete(UUID uuid);
    Producto getById(UUID uuid);
    List<Producto> getAll(UUID hospitalId, int page, int rows);

}