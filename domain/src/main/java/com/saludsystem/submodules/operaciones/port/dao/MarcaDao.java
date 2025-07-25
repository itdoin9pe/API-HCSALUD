package com.saludsystem.submodules.operaciones.port.dao;

import com.saludsystem.submodules.operaciones.model.Marca;

import java.util.List;
import java.util.UUID;

public interface MarcaDao {
    Marca save(Marca marca);
    Marca update(UUID uuid, Marca marca);
    void delete(UUID uuid);
    Marca getById(UUID uuid);
    List<Marca> getAll(UUID hospitalId, int page, int rows);
}