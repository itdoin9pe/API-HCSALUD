package com.saludsystem.submodules.configuracion.model.entity.value_objet.usuario;

public record Direccion(String valor) {
    public Direccion {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("La dirección no puede estar vacía.");
        }
    }
}