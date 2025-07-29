package com.saludsystem.submodules.configuracion.model.entity.vo.usuario;

import java.util.UUID;

public record UserRole(UUID value) {
    public UserRole{
        if (value == null) {
            throw new IllegalArgumentException("ID de rol not cant be null");
        }
    }
}
