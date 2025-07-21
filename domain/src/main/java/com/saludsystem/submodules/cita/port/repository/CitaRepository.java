package com.saludsystem.submodules.cita.port.repository;

import com.saludsystem.submodules.cita.model.entity.Cita;

import java.util.UUID;

public interface CitaRepository {
    Cita save(Cita cita);
    Cita update(UUID uuid, Cita cita);
    void delete(UUID uuid);
}