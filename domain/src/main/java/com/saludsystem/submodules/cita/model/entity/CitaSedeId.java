package com.saludsystem.submodules.cita.model.entity;

import java.util.UUID;

public record CitaSedeId(UUID value) {
    public CitaSedeId {
        if (value == null) {
            throw new IllegalArgumentException("El id de la sede no puede ser nulo.");
        }
    }
}