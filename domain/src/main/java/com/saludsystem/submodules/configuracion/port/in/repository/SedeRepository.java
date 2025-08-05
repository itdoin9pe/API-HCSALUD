package com.saludsystem.submodules.configuracion.port.in.repository;

import com.saludsystem.submodules.configuracion.model.Sede;

import java.util.UUID;

public interface SedeRepository {
    Sede save(Sede sede);
    Sede update(UUID uuid, Sede sede);
    void delete(UUID uuid);
}