package com.saludsystem.submodules.configuracion.port.in.repository;

import com.saludsystem.submodules.configuracion.model.Permiso;

import java.util.List;
import java.util.UUID;

public interface PermisoService {
    Permiso save(Permiso permiso);
    Permiso update(UUID uuid, Permiso permiso);
    void delete(UUID uuid);
    Permiso getById(UUID uuid);
    List<Permiso> getAll(UUID hospitalId, int page, int rows);
}