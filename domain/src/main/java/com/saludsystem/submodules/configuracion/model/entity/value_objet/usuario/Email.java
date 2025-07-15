package com.saludsystem.submodules.configuracion.model.entity.value_objet.usuario;

public record Email(String value) {
    public Email {
        if (value == null || !value.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")){
            throw new IllegalArgumentException("Email inválido");
        }
    }
}