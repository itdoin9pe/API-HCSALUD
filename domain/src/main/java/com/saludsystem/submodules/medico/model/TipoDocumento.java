package com.saludsystem.submodules.medico.model;

public record TipoDocumento(String value) {

    public TipoDocumento{
        if (value == null) {
            throw new IllegalArgumentException("Tipo de documento no valido");
        }
    }
}
