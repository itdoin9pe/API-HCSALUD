package com.saludsystem.submodules.configuracion.model.entity.value_objet.usuario;

public record EstadoUsuario(Integer valor) {
    public EstadoUsuario {
        if (valor == null || valor < 0 || valor > 2) {
            throw new IllegalArgumentException("El estado debe ser 0 (inactivo), 1 (activo) o 2 (suspendido).");
        }
    }

    public boolean esActivo() {
        return valor == 1;
    }

    public boolean esInactivo() {
        return valor == 0;
    }

    public boolean esSuspendido() {
        return valor == 2;
    }
}