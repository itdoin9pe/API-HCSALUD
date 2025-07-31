package com.saludsystem.submodules.cita.model.vo;

import java.util.UUID;

public record CitaEspecialidadId(UUID value) {
    public CitaEspecialidadId {
        if (value == null) {
            throw new IllegalArgumentException("El id de especialidad no puede ser nulo.");
        }
    }
}
