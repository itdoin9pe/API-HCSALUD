package com.saludsystem.submodules.mantenimiento.port.repository;

import com.saludsystem.submodules.mantenimiento.model.TipoGasto;

import java.util.UUID;

public interface TipoGastoRepository {
    TipoGasto save(TipoGasto tipoGasto);
    TipoGasto update(UUID uuid, TipoGasto tipoGasto);
    void delete(UUID uuid);
}