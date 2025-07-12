package com.saludsystem.domain.catalogo.port.in.service;

import com.saludsystem.domain.catalogo.model.Especialidad;

import java.util.List;
import java.util.UUID;

public interface EspecialidadService {
    Especialidad save(Especialidad especialidad);
    Especialidad update(UUID uuid, Especialidad especialidad);
    void delete(UUID uuid);
    Especialidad getById(UUID uuid);
    List<Especialidad> getAll(UUID hospitalId, int page, int rows);
}