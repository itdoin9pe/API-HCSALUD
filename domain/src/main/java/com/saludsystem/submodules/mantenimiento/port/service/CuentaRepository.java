package com.saludsystem.submodules.mantenimiento.port.service;

import com.saludsystem.submodules.mantenimiento.model.Cuenta;

import java.util.List;
import java.util.UUID;

public interface CuentaRepository {
    Cuenta save(Cuenta cuenta);
    Cuenta update(UUID uuid, Cuenta cuenta);
    void delete(UUID uuid);
    Cuenta getById(UUID uuid);
    List<Cuenta> getAll(UUID hospitalId, int page, int rows);
}