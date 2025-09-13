package com.saludsystem.submodules.configuracion.model.dtos.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RefreshTokenRequest
{
	@NotBlank
	private String refreshToken;
}