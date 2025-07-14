package com.saludsystem.domain.paciente.port.in.service;

import com.saludsystem.domain.paciente.model.Receta;

import java.util.List;
import java.util.UUID;

public interface RecetaService {
    Receta save(Receta receta);
    Receta update(UUID uuid, Receta receta);
    void delete(UUID uuid);
    Receta getById(UUID uuid);
    List<Receta> getAll(UUID hospitalId, int page, int rows);
}