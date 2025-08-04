package com.saludsystem.submodules.configuracion.model.dtos.auth;

public record AuthResponseDto(
        String accessToken, String refreshToken, long expiresIn) {

}
