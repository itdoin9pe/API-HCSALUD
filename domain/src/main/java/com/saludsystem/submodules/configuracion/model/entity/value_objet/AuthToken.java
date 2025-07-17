package com.saludsystem.submodules.configuracion.model.entity.value_objet;

public record AuthToken(
        String accessToken,
        String refreshToken,
        long expiresIn) {

}