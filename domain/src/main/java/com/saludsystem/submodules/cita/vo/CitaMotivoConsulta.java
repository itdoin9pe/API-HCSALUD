package com.saludsystem.submodules.cita.vo;

public record CitaMotivoConsulta(String value) {
    public CitaMotivoConsulta {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El motivo de consulta no puede estar vacío.");
        }
        if (value.length() > 500) {
            throw new IllegalArgumentException("El motivo de consulta no puede superar los 500 caracteres.");
        }
    }
}
