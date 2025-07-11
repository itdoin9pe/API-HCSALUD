package com.saludsystem.domain.cita.port.in.service;

import com.saludsystem.domain.cita.model.Cita;

import java.util.List;
import java.util.UUID;

public interface CitaService {
    Cita save(Cita cita);
    Cita update(UUID uuid, Cita cita);
    void delete(UUID uuid);
    Cita getById(UUID uuid);
    List<Cita> getAll(UUID hospitalId, int page, int rows);
}