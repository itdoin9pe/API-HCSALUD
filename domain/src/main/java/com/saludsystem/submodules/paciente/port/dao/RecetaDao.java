package com.saludsystem.submodules.paciente.port.dao;

import com.saludsystem.submodules.paciente.model.entity.Receta;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface RecetaDao {

    Receta getById(UUID uuid);
    ListResponse<Receta> getAll(UUID hospitalId, int page, int rows);
    List<Receta> getList();

}