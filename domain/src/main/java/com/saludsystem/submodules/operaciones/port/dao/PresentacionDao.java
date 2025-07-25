package com.saludsystem.submodules.operaciones.port.dao;

import com.saludsystem.submodules.operaciones.model.Presentacion;

import java.util.List;
import java.util.UUID;

public interface PresentacionDao {
    Presentacion save(Presentacion presentacion);
    Presentacion update(UUID uuid, Presentacion presentacion);
    void delete(UUID uuid);
    Presentacion getById(UUID uuid);
    List<Presentacion> getAll(UUID hospitalId, int page, int rows);
}