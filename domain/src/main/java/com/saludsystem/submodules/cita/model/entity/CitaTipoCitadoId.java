package com.saludsystem.submodules.cita.model.entity;

import java.util.UUID;

public record CitaTipoCitadoId(UUID value) {
    public CitaTipoCitadoId {
        if (value == null) {
            throw new IllegalArgumentException("El tipo de citado no puede ser nulo.");
        }
    }
}
