package com.saludsystem.submodules.operaciones.port.repository;

import com.saludsystem.submodules.operaciones.model.Presentacion;

import java.util.UUID;

public interface PresentacionRepository {

    Presentacion save(Presentacion presentacion);
    Presentacion update(UUID uuid, Presentacion presentacion);
    void delete(UUID uuid);

}