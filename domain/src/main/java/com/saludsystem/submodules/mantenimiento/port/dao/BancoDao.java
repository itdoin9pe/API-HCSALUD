package com.saludsystem.submodules.mantenimiento.port.dao;

import com.saludsystem.submodules.mantenimiento.model.Banco;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface BancoDao {
    Banco getById(UUID uuid);
    ListResponse<Banco> getAll(UUID hospitalId, int page, int rows);
    List<Banco> getList();
}