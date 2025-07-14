package com.saludsystem.submodules.operaciones.port.in.service;

import com.saludsystem.submodules.operaciones.model.Unidad;

import java.util.List;
import java.util.UUID;

public interface  UnidadService  {
    Unidad save(Unidad unidad);
    Unidad update(UUID uuid, Unidad unidad);
    void delete(UUID uuid);
    Unidad getById(UUID uuid);
    List<Unidad> getAll(UUID hospitalId, int page, int rows);
}