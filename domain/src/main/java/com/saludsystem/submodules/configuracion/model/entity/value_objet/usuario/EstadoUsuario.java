package com.saludsystem.submodules.configuracion.model.entity.value_objet.usuario;

public record EstadoUsuario(Integer value) {
    public EstadoUsuario {
        if (value == null || value < 0 || value > 2) {
            throw new IllegalArgumentException("El estado debe ser 0 (inactivo), 1 (activo) o 2 (suspendido).");
        }
    }

    public boolean esActivo() {
        return value == 1;
    }

    public boolean esInactivo() {
        return value == 0;
    }

    public boolean esSuspendido() {
        return value == 2;
    }
}