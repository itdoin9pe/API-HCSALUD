package com.saludsystem.submodules.configuracion.vo;

public record AuthToken(
        String accessToken,
        String refreshToken,
        long expiresIn) {

}