package com.saludsystem.submodules.catalogo.port.dao;

import com.saludsystem.submodules.catalogo.model.Cliente;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface ClienteDao {
    Cliente getById(UUID uuid);
    ListResponse<Cliente> getAll(UUID hospitalId, int page, int rows);
    List<Cliente> getList();
}