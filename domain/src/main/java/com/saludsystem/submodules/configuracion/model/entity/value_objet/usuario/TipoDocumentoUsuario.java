package com.saludsystem.submodules.configuracion.model.entity.value_objet.usuario;

public record TipoDocumentoUsuario(String valor) {
    public TipoDocumentoUsuario {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de documento no puede estar vacío.");
        }
    }
}