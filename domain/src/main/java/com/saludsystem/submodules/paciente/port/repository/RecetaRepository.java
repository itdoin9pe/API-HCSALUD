package com.saludsystem.submodules.paciente.port.repository;

import com.saludsystem.submodules.paciente.model.entity.Receta;

import java.util.UUID;

public interface RecetaRepository {

    Receta save(Receta receta);
    Receta update(UUID uuid, Receta receta);
    void delete(UUID uuid);

}