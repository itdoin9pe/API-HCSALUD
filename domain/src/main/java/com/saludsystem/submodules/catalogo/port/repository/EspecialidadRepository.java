package com.saludsystem.submodules.catalogo.port.repository;

import com.saludsystem.submodules.catalogo.model.Especialidad;

import java.util.UUID;

public interface EspecialidadRepository {
    Especialidad save(Especialidad especialidad);
    Especialidad update(UUID uuid, Especialidad especialidad);
    void delete(UUID uuid);
}