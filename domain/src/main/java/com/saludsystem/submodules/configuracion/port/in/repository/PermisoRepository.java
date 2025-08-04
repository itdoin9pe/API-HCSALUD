package com.saludsystem.submodules.configuracion.port.in.repository;

import com.saludsystem.submodules.configuracion.model.Permiso;

import java.util.UUID;

public interface PermisoRepository {
    Permiso save(Permiso permiso);
    Permiso update(UUID uuid, Permiso permiso);
    void delete(UUID uuid);
}