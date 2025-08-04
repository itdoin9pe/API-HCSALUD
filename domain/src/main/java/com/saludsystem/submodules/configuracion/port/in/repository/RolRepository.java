package com.saludsystem.submodules.configuracion.port.in.repository;

import com.saludsystem.submodules.configuracion.model.Rol;

import java.util.List;
import java.util.UUID;

public interface RolRepository {
    Rol save(Rol rol);
    Rol update(UUID uuid, Rol rol);
    void delete(UUID uuid);
    Rol getById(UUID uuid);
    List<Rol> getAll(UUID hospitalId, int page, int rows);
}