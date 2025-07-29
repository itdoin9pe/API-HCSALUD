package com.saludsystem.submodules.configuracion.model.entity.vo;

public record AuthToken(
        String accessToken,
        String refreshToken,
        long expiresIn) {

}