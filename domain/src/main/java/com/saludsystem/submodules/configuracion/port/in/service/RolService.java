package com.saludsystem.submodules.configuracion.port.in.service;

import com.saludsystem.submodules.configuracion.model.entity.Rol;

import java.util.List;
import java.util.UUID;

public interface RolService {
    Rol save(Rol rol);
    Rol update(UUID uuid, Rol rol);
    void delete(UUID uuid);
    Rol getById(UUID uuid);
    List<Rol> getAll(UUID hospitalId, int page, int rows);
}