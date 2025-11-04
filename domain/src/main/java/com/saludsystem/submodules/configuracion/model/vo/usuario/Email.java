package com.saludsystem.submodules.configuracion.model.vo.usuario;

public record Email(String value)
{
	public Email
	{
		if (value == null || value.trim().isEmpty())
		{
			throw new IllegalArgumentException("El email no puede ser nulo ni vacío");
		}
		if (!value.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"))
		{
			throw new IllegalArgumentException("Email inválido");
		}
	}
}
