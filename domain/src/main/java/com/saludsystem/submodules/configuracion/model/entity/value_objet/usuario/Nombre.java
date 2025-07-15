package com.saludsystem.submodules.configuracion.model.entity.value_objet.usuario;

public record Nombre(String valor) {
    public Nombre {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
    }
}