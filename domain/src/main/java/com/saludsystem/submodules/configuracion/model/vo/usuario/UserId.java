package com.saludsystem.submodules.configuracion.model.vo.usuario;

import java.util.UUID;

public record UserId(UUID value)
{
	public UserId
	{
		if (value == null)
		{
			throw new IllegalArgumentException("El ID de usuario no puede ser nulo.");
		}
	}
}