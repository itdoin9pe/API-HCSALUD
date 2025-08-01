package com.saludsystem.submodules.mantenimiento.port.repository;

import com.saludsystem.submodules.mantenimiento.model.Moneda;

import java.util.UUID;

public interface MonedaRepository {
    Moneda save(Moneda moneda);
    Moneda update(UUID uuid, Moneda moneda);
    void delete(UUID uuid);
}