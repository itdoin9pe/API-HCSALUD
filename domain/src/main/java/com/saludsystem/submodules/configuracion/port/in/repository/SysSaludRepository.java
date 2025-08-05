package com.saludsystem.submodules.configuracion.port.in.repository;

import com.saludsystem.submodules.configuracion.model.SysSalud;

import java.util.UUID;

public interface SysSaludRepository {
    SysSalud save(SysSalud sysSalud);
    SysSalud update(UUID uuid, SysSalud sysSalud);
    void delete(UUID uuid);
}