package com.saludsystem.submodules.cita.model.entity;

public record CitaObservacion(String value) {
    public CitaObservacion {
        if (value != null && value.length() > 500) {
            throw new IllegalArgumentException("La observación no puede superar los 500 caracteres.");
        }
    }
}
