package com.saludsystem.submodules.cita.vo;

import java.util.Set;

public record CitaEstado(String value) {
    private static final Set<String> VALID_STATES = Set.of("ACTIVA", "CANCELADA", "FINALIZADA", "REPROGRAMADA");

    public CitaEstado {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("El estado no puede estar vacío.");
        }
        if (!VALID_STATES.contains(value.toUpperCase())) {
            throw new IllegalArgumentException("Estado inválido: " + value);
        }
    }
}
