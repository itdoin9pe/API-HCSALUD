package com.saludsystem.submodules.cita.port.dao;

import com.saludsystem.submodules.cita.model.entity.Cita;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface CitaDao {
    Cita getById(UUID uuid);
    ListResponse<Cita> getAll(UUID hospitalId, int page, int rows);
    List<Cita> getList();
}
