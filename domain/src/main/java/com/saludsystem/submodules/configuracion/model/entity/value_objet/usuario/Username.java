package com.saludsystem.submodules.configuracion.model.entity.value_objet.usuario;


public record Username(String value) {
    public Username {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("El username no puede estar vacío");
        }
        if (value.length() < 4) {
            throw new IllegalArgumentException("El username debe tener al menos 4 caracteres");
        }
    }

    @Override
    public String toString() {
        return value;
    }
}