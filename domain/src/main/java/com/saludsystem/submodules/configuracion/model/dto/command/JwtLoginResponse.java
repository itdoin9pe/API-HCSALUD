package com.saludsystem.submodules.configuracion.model.dto.command;

public record JwtLoginResponse(
        String access_token,
        String refresh_token,
        long expires_in
) {}
