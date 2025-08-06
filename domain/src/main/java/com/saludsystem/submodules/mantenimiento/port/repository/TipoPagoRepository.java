package com.saludsystem.submodules.mantenimiento.port.repository;

import com.saludsystem.submodules.mantenimiento.model.TipoPago;

import java.util.UUID;

public interface TipoPagoRepository {
    TipoPago save(TipoPago tipoPago);
    TipoPago update(UUID uuid, TipoPago tipoPago);
    void delete(UUID uuid);
}