package com.saludsystem.submodules.mantenimiento.port.dao;

import com.saludsystem.submodules.mantenimiento.model.Caja;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface CajaDao {
    Caja getById(UUID uuid);
    ListResponse<Caja> getAll(UUID hospitalId, int page, int rows);
    List<Caja> getList();
}