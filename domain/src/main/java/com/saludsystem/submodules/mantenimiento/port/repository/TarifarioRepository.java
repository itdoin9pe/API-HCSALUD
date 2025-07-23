package com.saludsystem.submodules.mantenimiento.port.repository;

import com.saludsystem.submodules.mantenimiento.model.Tarifario;

import java.util.UUID;

public interface TarifarioRepository {
    Tarifario save(Tarifario tarifario);
    Tarifario update(UUID uuid, Tarifario tarifario);
    void delete(UUID uuid);
}