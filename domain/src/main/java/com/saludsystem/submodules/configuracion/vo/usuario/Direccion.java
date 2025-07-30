package com.saludsystem.submodules.configuracion.vo.usuario;

public record Direccion(String value) {
    public Direccion {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("La dirección no puede estar vacía.");
        }
    }
}