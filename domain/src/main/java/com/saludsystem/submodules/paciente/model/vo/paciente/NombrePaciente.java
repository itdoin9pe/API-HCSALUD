package com.saludsystem.submodules.paciente.model.vo.paciente;

import java.util.Objects;

public record NombrePaciente(String value)
{
	public NombrePaciente
	{
		Objects.requireNonNull(value, "El nombre no puede ser nulo");
		value = value.trim();
		if (value.isBlank())
		{
			throw new IllegalArgumentException("El nombre no puede estar vacío");
		}
	}
}