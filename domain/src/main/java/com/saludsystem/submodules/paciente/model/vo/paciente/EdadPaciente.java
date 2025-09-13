package com.saludsystem.submodules.paciente.model.vo.paciente;

import java.util.Objects;

public record EdadPaciente(Integer value)
{
	public EdadPaciente
	{
		Objects.requireNonNull(value, "La edad no puede ser nula");
		if (value < 0 || value > 120)
		{
			throw new IllegalArgumentException("La edad debe estar entre 0 y 120");
		}
	}
}