package com.saludsystem.submodules.configuracion.port.in.dao;

import com.saludsystem.submodules.configuracion.model.Usuario;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface UserDao {
    Usuario getById(UUID uuid);
    ListResponse<Usuario> getAll(UUID hospitalId, int page, int rows);
    List<Usuario> getList();
}
