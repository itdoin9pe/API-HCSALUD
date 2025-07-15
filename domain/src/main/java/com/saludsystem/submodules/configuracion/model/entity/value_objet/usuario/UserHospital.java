package com.saludsystem.submodules.configuracion.model.entity.value_objet.usuario;

import java.util.UUID;

public record UserHospital(UUID value) {
    public UserHospital {
        if (value == null) {
            throw new IllegalArgumentException("Id hospital not can be null");
        }
    }
}
