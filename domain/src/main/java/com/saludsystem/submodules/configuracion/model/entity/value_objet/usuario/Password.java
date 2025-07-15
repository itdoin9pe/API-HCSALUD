package com.saludsystem.submodules.configuracion.model.entity.value_objet.usuario;

public record Password(String value) {
    public Password {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("La contraseña no puede estar vacía");
        }
        if (value.length() < 7) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 8 caracteres");
        }
    }

    @Override
    public String toString() {
        return "********"; // Evita mostrar el valor real
    }
}