package com.saludsystem.submodules.principal.port.dao;

import com.saludsystem.submodules.principal.model.Estudio;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface EstudioDao {
    Estudio getById(UUID uuid);
    ListResponse<Estudio> getAll(UUID hospitalId, int page, int rows);
    List<Estudio> getList();
}