package com.saludsystem.submodules.mantenimiento.port.in.service;

import com.saludsystem.submodules.mantenimiento.model.Caja;

import java.util.List;
import java.util.UUID;

public interface CajaService {
    Caja save(Caja caja);
    Caja update(UUID uuid, Caja caja);
    void delete(UUID uuid);
    Caja getById(UUID uuid);
    List<Caja> getAll(UUID hospitalId, int page, int rows);
}