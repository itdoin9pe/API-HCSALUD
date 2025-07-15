package com.saludsystem.submodules.configuracion.model.entity;

public record AuthToken(
        String accessToken,
        String refreshToken,
        long expiresIn) {

}