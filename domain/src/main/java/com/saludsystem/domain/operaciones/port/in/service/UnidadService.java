package com.saludsystem.domain.operaciones.port.in.service;

import com.saludsystem.domain.operaciones.model.Unidad;

import java.util.List;
import java.util.UUID;

public interface  UnidadService  {
    Unidad save(Unidad unidad);
    Unidad update(UUID uuid, Unidad unidad);
    void delete(UUID uuid);
    Unidad getById(UUID uuid);
    List<Unidad> getAll(UUID hospitalId, int page, int rows);
}