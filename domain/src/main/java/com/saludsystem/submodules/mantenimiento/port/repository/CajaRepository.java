package com.saludsystem.submodules.mantenimiento.port.repository;

import com.saludsystem.submodules.mantenimiento.model.Caja;

import java.util.UUID;

public interface CajaRepository {
    Caja save(Caja caja);
    Caja update(UUID uuid, Caja caja);
    void delete(UUID uuid);
}