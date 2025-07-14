package com.saludsystem.domain.mantenimiento.port.in.service;

import com.saludsystem.domain.catalogo.model.TipoCitado;
import com.saludsystem.domain.mantenimiento.model.TipoGasto;

import java.util.List;
import java.util.UUID;

public interface TipoGastoService {
    TipoGasto save(TipoGasto tipoGasto);
    TipoGasto update(UUID uuid, TipoGasto tipoGasto);
    void delete(UUID uuid);
    TipoGasto getById(UUID uuid);
    List<TipoGasto> getAll(UUID hospitalId, int page, int rows);
}