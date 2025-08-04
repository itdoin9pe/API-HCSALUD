package com.saludsystem.submodules.configuracion.model.vo;

public record AuthToken(
        String accessToken,
        String refreshToken,
        long expiresIn) {

}