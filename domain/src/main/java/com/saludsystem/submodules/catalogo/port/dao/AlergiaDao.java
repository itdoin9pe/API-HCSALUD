package com.saludsystem.submodules.catalogo.port.dao;

import com.saludsystem.submodules.catalogo.model.Alergia;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface AlergiaDao {
    Alergia getById(UUID id);
    ListResponse<Alergia> getAll(UUID hospitalId, int page, int rows);
    List<Alergia> getList();
}