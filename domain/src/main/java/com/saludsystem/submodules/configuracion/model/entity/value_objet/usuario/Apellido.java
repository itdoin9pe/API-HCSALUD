package com.saludsystem.submodules.configuracion.model.entity.value_objet.usuario;

public record Apellido(String value) {
    public Apellido {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido no puede estar vacío.");
        }
    }
}