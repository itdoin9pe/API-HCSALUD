package com.saludsystem.submodules.configuracion.model.entity.value_objet.usuario;

public record TipoDocumentoUsuario(String value) {
    public TipoDocumentoUsuario {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de documento no puede estar vacío.");
        }
    }
}