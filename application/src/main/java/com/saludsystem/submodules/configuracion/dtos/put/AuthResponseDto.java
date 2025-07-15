package com.saludsystem.submodules.configuracion.dtos.put;

public record AuthResponseDto(
        String accessToken, String refreshToken, long expiresIn) {

}
