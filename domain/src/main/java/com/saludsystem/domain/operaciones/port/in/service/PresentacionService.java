package com.saludsystem.domain.operaciones.port.in.service;

import com.saludsystem.domain.operaciones.model.Presentacion;

import java.util.List;
import java.util.UUID;

public interface PresentacionService {
    Presentacion save(Presentacion presentacion);
    Presentacion update(UUID uuid, Presentacion presentacion);
    void delete(UUID uuid);
    Presentacion getById(UUID uuid);
    List<Presentacion> getAll(UUID hospitalId, int page, int rows);
}