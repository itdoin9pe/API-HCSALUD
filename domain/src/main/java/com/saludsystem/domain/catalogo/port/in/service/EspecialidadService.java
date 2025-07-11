package com.saludsystem.domain.catalogo.port.in.service;

import com.saludsystem.domain.catalogo.model.Categoria;
import com.saludsystem.domain.catalogo.model.Especialidad;

import java.util.List;
import java.util.UUID;

public interface EspecialidadService {
    Especialidad save(Categoria categoria);
    Especialidad update(UUID uuid, Categoria categoria);
    void delete(UUID uuid);
    Especialidad getById(UUID uuid);
    List<Especialidad> getAll(UUID hospitalId, int page, int rows);
}