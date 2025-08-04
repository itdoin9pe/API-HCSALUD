package com.saludsystem.submodules.operaciones.port.repository;

import com.saludsystem.submodules.operaciones.model.Unidad;

import java.util.UUID;

public interface UnidadRepository {

    Unidad save(Unidad unidad);
    Unidad update(UUID uuid, Unidad unidad);
    void delete(UUID uuid);

}