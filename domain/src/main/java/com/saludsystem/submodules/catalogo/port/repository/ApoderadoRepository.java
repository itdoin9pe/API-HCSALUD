package com.saludsystem.submodules.catalogo.port.repository;

import com.saludsystem.submodules.catalogo.model.Apoderado;

import java.util.UUID;

public interface ApoderadoRepository {
    Apoderado save(Apoderado apoderado);
    Apoderado update(UUID uuid, Apoderado apoderado);
    void delete(UUID uuid);
}