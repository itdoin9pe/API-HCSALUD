package com.saludsystem.submodules.mantenimiento.port.in.service;

import com.saludsystem.submodules.mantenimiento.model.Tarifario;

import java.util.List;
import java.util.UUID;

public interface TarifarioService {
    Tarifario save(Tarifario tarifario);
    Tarifario update(UUID uuid, Tarifario tarifario);
    void delete(UUID uuid);
    Tarifario getById(UUID uuid);
    List<Tarifario> getAll(UUID hospitalId, int page, int rows);
}