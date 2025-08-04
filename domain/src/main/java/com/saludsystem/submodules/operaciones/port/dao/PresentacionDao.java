package com.saludsystem.submodules.operaciones.port.dao;

import com.saludsystem.submodules.operaciones.model.Presentacion;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface PresentacionDao {
    Presentacion getById(UUID uuid);
    ListResponse<Presentacion> getAll(UUID hospitalId, int page, int rows);
    List<Presentacion> getList();
}