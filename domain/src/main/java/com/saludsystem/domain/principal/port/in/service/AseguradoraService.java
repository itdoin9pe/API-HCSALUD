package com.saludsystem.domain.principal.port.in.service;

import com.saludsystem.domain.principal.model.Aseguradora;

import java.util.List;
import java.util.UUID;

public interface AseguradoraService {
    Aseguradora save(Aseguradora aseguradora);
    Aseguradora update(UUID uuid, Aseguradora aseguradora);
    void delete(UUID uuid);
    Aseguradora getById(UUID uuid);
    List<Aseguradora> getAll(UUID hospitalId, int page, int rows);
}