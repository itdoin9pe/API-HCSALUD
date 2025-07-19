package com.saludsystem.submodules.catalogo.port.dao;

import com.saludsystem.submodules.catalogo.model.Medida;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface MedidaDao {
    Medida getById(UUID uuid);
    ListResponse<Medida> getAll(UUID hospitalId, int page, int rows);
    List<Medida> getList();
}