package com.saludsystem.submodules.catalogo.port.in.service;

import com.saludsystem.submodules.catalogo.model.Apoderado;

import java.util.List;
import java.util.UUID;

public interface ApoderadoService {
    Apoderado save(Apoderado apoderado);
    Apoderado update(UUID uuid, Apoderado apoderado);
    void delete(UUID uuid);
    Apoderado getById(UUID uuid);
    List<Apoderado> getAll(UUID hospitalId, int page, int rows);
}