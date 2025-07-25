package com.saludsystem.submodules.principal.port.dao;

import com.saludsystem.submodules.principal.model.Empresa;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface EmpresaDao {
    Empresa getById(UUID uuid);
    ListResponse<Empresa> getAll(UUID hospitalId, int page, int rows);
    List<Empresa> getList();
}