package com.saludsystem.domain.mantenimiento.port.in.service;

import com.saludsystem.domain.mantenimiento.model.TipoTarjeta;

import java.util.List;
import java.util.UUID;

public interface TipoTarjetaService {
    TipoTarjeta save(TipoTarjeta tipoTarjeta);
    TipoTarjeta update(UUID uuid, TipoTarjeta tipoTarjeta);
    void delete(UUID uuid);
    TipoTarjeta getById(UUID uuid);
    List<TipoTarjeta> getAll(UUID hospitalId, int page, int rows);
}