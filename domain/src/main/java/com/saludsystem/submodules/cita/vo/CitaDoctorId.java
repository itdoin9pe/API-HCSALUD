package com.saludsystem.submodules.cita.vo;

import java.util.UUID;

public record CitaDoctorId(UUID value) {
    public CitaDoctorId {
        if (value == null) {
            throw new IllegalArgumentException("El id del doctor no puede ser nulo.");
        }
    }
}