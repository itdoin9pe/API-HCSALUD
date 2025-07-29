package com.saludsystem.submodules.configuracion.model.entity.vo.usuario;

public record PhoneNumber(String value) {
    public PhoneNumber {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("El número de teléfono no puede estar vacío");
        }
        if (!value.matches("\\d{9}")) {
            throw new IllegalArgumentException("El número de teléfono debe tener 9 dígitos");
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
