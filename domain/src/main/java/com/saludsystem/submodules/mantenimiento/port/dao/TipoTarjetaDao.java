package com.saludsystem.submodules.mantenimiento.port.dao;

import com.saludsystem.submodules.mantenimiento.model.TipoTarjeta;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface TipoTarjetaDao {
    TipoTarjeta getById(UUID uuid);
    ListResponse<TipoTarjeta> getAll(UUID hospitalId, int page, int rows);
    List<TipoTarjeta> getList();
}