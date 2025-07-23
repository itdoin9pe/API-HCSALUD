package com.saludsystem.submodules.mantenimiento.port.repository;

import com.saludsystem.submodules.mantenimiento.model.TipoTarjeta;

import java.util.List;
import java.util.UUID;

public interface TipoTarjetaRepository {
    TipoTarjeta save(TipoTarjeta tipoTarjeta);
    TipoTarjeta update(UUID uuid, TipoTarjeta tipoTarjeta);
    void delete(UUID uuid);
    TipoTarjeta getById(UUID uuid);
    List<TipoTarjeta> getAll(UUID hospitalId, int page, int rows);
}