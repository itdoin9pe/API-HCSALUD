package com.saludsystem.submodules.cita.model.vo;

import java.util.UUID;

public record CitaPacienteId(UUID value) {
    public CitaPacienteId {
        if (value == null) {
            throw new IllegalArgumentException("El id del paciente no puede ser nulo.");
        }
    }
}
