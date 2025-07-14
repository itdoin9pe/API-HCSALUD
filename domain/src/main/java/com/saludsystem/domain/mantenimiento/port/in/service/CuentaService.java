package com.saludsystem.domain.mantenimiento.port.in.service;

import com.saludsystem.domain.mantenimiento.model.Cuenta;

import java.util.List;
import java.util.UUID;

public interface CuentaService {
    Cuenta save(Cuenta cuenta);
    Cuenta update(UUID uuid, Cuenta cuenta);
    void delete(UUID uuid);
    Cuenta getById(UUID uuid);
    List<Cuenta> getAll(UUID hospitalId, int page, int rows);
}