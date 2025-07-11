package com.saludsystem.domain.catalogo.port.in.service;

import com.saludsystem.domain.catalogo.model.Apoderado;

import java.util.List;
import java.util.UUID;

public interface ApoderadoService {
    Apoderado save(Apoderado apoderado);
    Apoderado update(UUID uuid, Apoderado apoderado);
    void delete(UUID uuid);
    Apoderado getById(UUID uuid);
    List<Apoderado> getAll(UUID hospitalId, int page, int rows);
}