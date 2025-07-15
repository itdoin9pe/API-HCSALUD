package com.saludsystem.submodules.configuracion.model.entity.value_objet.usuario;

public record Apellido(String valor) {
    public Apellido {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido no puede estar vacío.");
        }
    }
}