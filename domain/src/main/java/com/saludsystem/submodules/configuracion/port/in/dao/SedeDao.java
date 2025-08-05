package com.saludsystem.submodules.configuracion.port.in.dao;

import com.saludsystem.submodules.configuracion.model.Sede;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface SedeDao {
    Sede getById(UUID uuid);
    ListResponse<Sede> getAll(UUID hospitalId, int page, int rows);
    List<Sede> getList();
}
