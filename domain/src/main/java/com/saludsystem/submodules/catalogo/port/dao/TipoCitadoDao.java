package com.saludsystem.submodules.catalogo.port.dao;

import com.saludsystem.submodules.catalogo.model.TipoCitado;

import java.util.List;
import java.util.UUID;

public interface TipoCitadoDao {
    TipoCitado save(TipoCitado tipoCitado);
    TipoCitado update(UUID uuid, TipoCitado tipoCitado);
    void delete(UUID uuid);
    TipoCitado getById(UUID uuid);
    List<TipoCitado> getAll(UUID hospitalId, int page, int rows);
}