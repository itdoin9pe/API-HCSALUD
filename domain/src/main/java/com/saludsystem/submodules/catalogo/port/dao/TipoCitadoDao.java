package com.saludsystem.submodules.catalogo.port.dao;

import com.saludsystem.submodules.catalogo.model.TipoCitado;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface TipoCitadoDao {
    TipoCitado getById(UUID uuid);
    ListResponse<TipoCitado> getAll(UUID hospitalId, int page, int rows);
    List<TipoCitado> getList();
}