package com.saludsystem.submodules.configuracion.model.dto;

import jakarta.validation.constraints.NotBlank;

public class TokenRefreshRequest {
    @NotBlank
    private String refreshToken;
}
