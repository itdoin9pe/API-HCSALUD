package com.saludsystem.submodules.mantenimiento.port.dao;

import com.saludsystem.submodules.mantenimiento.model.Tarifario;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface TarifarioDao {
    Tarifario getById(UUID uuid);
    ListResponse<Tarifario> getAll(UUID hospitalId, int page, int rows);
    List<Tarifario> getList();
}