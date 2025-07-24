package com.saludsystem.submodules.mantenimiento.port.dao;

import com.saludsystem.submodules.mantenimiento.model.TipoGasto;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface TipoGastoDao {
    TipoGasto getById(UUID uuid);
    ListResponse<TipoGasto> getAll(UUID hospitalId, int page, int rows);
    List<TipoGasto> getList();
}