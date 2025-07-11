package com.saludsystem.domain.configuracion.port.in.service;

import com.saludsystem.domain.configuracion.model.Sede;

import java.util.List;
import java.util.UUID;

public interface SedeService {
    Sede save(Sede sede);
    Sede update(UUID uuid, Sede sede);
    void delete(UUID uuid);
    Sede getById(UUID uuid);
    List<Sede> getAll(UUID hospitalId, int page, int rows);
}