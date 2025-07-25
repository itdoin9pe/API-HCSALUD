package com.saludsystem.submodules.principal.port.dao;

import com.saludsystem.submodules.principal.model.Aseguradora;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface AseguradoraDao {
    Aseguradora getById(UUID uuid);
    ListResponse<Aseguradora> getAll(UUID hospitalId, int page, int rows);
    List<Aseguradora> getList();
}