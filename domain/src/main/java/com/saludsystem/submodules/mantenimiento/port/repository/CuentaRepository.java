package com.saludsystem.submodules.mantenimiento.port.repository;

import com.saludsystem.submodules.mantenimiento.model.Cuenta;

import java.util.UUID;

public interface CuentaRepository {
    Cuenta save(Cuenta cuenta);
    Cuenta update(UUID uuid, Cuenta cuenta);
    void delete(UUID uuid);
}