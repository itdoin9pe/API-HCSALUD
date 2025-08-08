package com.saludsystem.submodules.paciente.model.vo.paciente;

import java.util.Objects;

public record NumeroDocPaciente(String value) {
    public NumeroDocPaciente {
        Objects.requireNonNull(value, "El número de documento no puede ser nulo");
        value = value.trim();
        if (value.isBlank()) {
            throw new IllegalArgumentException("El número de documento no puede estar vacío");
        }
    }
}