package com.saludsystem.submodules.catalogo.port.dao;

import com.saludsystem.submodules.catalogo.model.Apoderado;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface ApoderadoDao {
    Apoderado getById(UUID uuid);
    ListResponse<Apoderado> getAll(UUID hospitalId, int page, int rows);
    List<Apoderado> getList();
}