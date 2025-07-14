package com.saludsystem.domain.mantenimiento.port.in.service;

import com.saludsystem.domain.mantenimiento.model.Moneda;

import java.util.List;
import java.util.UUID;

public interface MonedaService {
    Moneda save(Moneda tipoCitado);
    Moneda update(UUID uuid, Moneda tipoCitado);
    void delete(UUID uuid);
    Moneda getById(UUID uuid);
    List<Moneda> getAll(UUID hospitalId, int page, int rows);
}