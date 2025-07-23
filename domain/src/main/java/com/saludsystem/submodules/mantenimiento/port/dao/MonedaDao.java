package com.saludsystem.submodules.mantenimiento.port.dao;

import com.saludsystem.submodules.mantenimiento.model.Moneda;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface MonedaDao {
    Moneda getById(UUID uuid);
    ListResponse<Moneda> getAll(UUID hospitalId, int page, int rows);
    List<Moneda> getList();
}