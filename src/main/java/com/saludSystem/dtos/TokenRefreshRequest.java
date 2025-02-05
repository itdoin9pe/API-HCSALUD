package com.saludSystem.dtos;

import lombok.Data;

@Data
public class TokenRefreshRequest {
    private String refreshToken;
}
