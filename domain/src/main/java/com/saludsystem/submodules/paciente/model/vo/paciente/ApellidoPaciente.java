package com.saludsystem.submodules.paciente.model.vo.paciente;

import java.util.Objects;

public record ApellidoPaciente(String value)
{
	public ApellidoPaciente
	{
		Objects.requireNonNull(value, "El apellido no puede ser nulo");
		value = value.trim();
		if (value.isBlank())
		{
			throw new IllegalArgumentException("El apellido no puede estar vacío");
		}
	}
}