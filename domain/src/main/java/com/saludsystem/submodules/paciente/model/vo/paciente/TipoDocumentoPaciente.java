package com.saludsystem.submodules.paciente.model.vo.paciente;

import java.util.Objects;

public record TipoDocumentoPaciente(String value)
{
	public TipoDocumentoPaciente
	{
		Objects.requireNonNull(value, "El tipo de documento no puede ser nulo");
		value = value.trim().toUpperCase();
		if (value.isBlank())
		{
			throw new IllegalArgumentException("El tipo de documento no puede estar vacío");
		}
	}
}