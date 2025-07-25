package com.saludsystem.submodules.paciente.port.dao;

import com.saludsystem.submodules.paciente.model.entity.Receta;

import java.util.List;
import java.util.UUID;

public interface RecetaDao {
    Receta save(Receta receta);
    Receta update(UUID uuid, Receta receta);
    void delete(UUID uuid);
    Receta getById(UUID uuid);
    List<Receta> getAll(UUID hospitalId, int page, int rows);
}