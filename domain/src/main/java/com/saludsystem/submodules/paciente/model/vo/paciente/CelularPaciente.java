package com.saludsystem.submodules.paciente.model.vo.paciente;

public record CelularPaciente(String value) {
    public CelularPaciente {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("El número de celular no puede estar vacío");
        }
        if (!value.matches("\\d{9}")) {
            throw new IllegalArgumentException("El celular debe tener 9 dígitos");
        }
    }
}