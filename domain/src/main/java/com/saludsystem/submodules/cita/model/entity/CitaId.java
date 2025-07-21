package com.saludsystem.submodules.cita.model.entity;

import java.util.UUID;

public record CitaId(UUID value) {
    public CitaId {
        if (value == null) {
            throw new IllegalArgumentException("El id de cita no es valido");
        }
    }
}
