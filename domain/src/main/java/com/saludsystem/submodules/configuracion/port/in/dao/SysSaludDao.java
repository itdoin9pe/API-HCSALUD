package com.saludsystem.submodules.configuracion.port.in.dao;

import com.saludsystem.submodules.configuracion.model.SysSalud;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface SysSaludDao {

    SysSalud getById(UUID uuid);
    ListResponse<SysSalud> getAll(UUID hospitalId, int page, int rows);
    List<SysSalud> getList();

}
