package com.saludsystem.submodules.configuracion.port.out;

import io.swagger.v3.oas.annotations.media.Schema;

public record JwtLoginResponse(
        String access_token,
        String refresh_token,
        @Schema(example = "4800")
        long expires_in
) {}
