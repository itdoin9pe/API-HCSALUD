package com.saludsystem.submodules.operaciones.port.repository;

import com.saludsystem.submodules.operaciones.model.Marca;

import java.util.UUID;

public interface MarcaRepository {
    Marca save(Marca marca);
    Marca update(UUID uuid, Marca marca);
    void delete(UUID uuid);
}