package com.saludsystem.domain.mantenimiento.port.in.service;

import com.saludsystem.domain.mantenimiento.model.TipoPago;

import java.util.List;
import java.util.UUID;

public interface TipoPagoService {
    TipoPago save(TipoPago tipoPago);
    TipoPago update(UUID uuid, TipoPago tipoPago);
    void delete(UUID uuid);
    TipoPago getById(UUID uuid);
    List<TipoPago> getAll(UUID hospitalId, int page, int rows);
}