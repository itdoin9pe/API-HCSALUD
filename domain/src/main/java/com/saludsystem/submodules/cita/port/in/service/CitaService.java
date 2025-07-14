package com.saludsystem.submodules.cita.port.in.service;

import com.saludsystem.submodules.cita.model.Cita;

import java.util.List;
import java.util.UUID;

public interface CitaService {
    Cita save(Cita cita);
    Cita update(UUID uuid, Cita cita);
    void delete(UUID uuid);
    Cita getById(UUID uuid);
    List<Cita> getAll(UUID hospitalId, int page, int rows);
}