package com.saludsystem.submodules.configuracion.model.vo.usuario;

public record Nombre(String value)
{
	public Nombre
	{
		if (value == null || value.trim().isEmpty())
		{
			throw new IllegalArgumentException("El nombre no puede estar vacío.");
		}
	}
}