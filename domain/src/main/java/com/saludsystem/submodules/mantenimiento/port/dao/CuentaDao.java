package com.saludsystem.submodules.mantenimiento.port.dao;

import com.saludsystem.submodules.mantenimiento.model.Cuenta;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface CuentaDao {
    Cuenta getById(UUID uuid);
    ListResponse<Cuenta> getAll(UUID hospitalId, int page, int rows);
    List<Cuenta> getList();
}