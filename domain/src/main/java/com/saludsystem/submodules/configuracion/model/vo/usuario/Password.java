package com.saludsystem.submodules.configuracion.model.vo.usuario;

public record Password(String value)
{
	public Password {
		if (value != null && !value.isBlank() && value.length() < 8) {
			throw new IllegalArgumentException("La contraseña debe tener al menos 7 caracteres");
		}
	}

	@Override
	public String toString()
	{
		return "********";
	}
}