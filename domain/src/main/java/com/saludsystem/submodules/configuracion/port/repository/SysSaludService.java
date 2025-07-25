package com.saludsystem.submodules.configuracion.port.repository;

import com.saludsystem.submodules.configuracion.model.entity.SysSalud;

import java.util.List;
import java.util.UUID;

public interface SysSaludService {
    SysSalud save(SysSalud sysSalud);
    SysSalud update(UUID uuid, SysSalud sysSalud);
    void delete(UUID uuid);
    SysSalud getById(UUID uuid);
    List<SysSalud> getAll(UUID hospitalId, int page, int rows);
}