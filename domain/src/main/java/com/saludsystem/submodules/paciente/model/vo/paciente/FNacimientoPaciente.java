package com.saludsystem.submodules.paciente.model.vo.paciente;

import java.time.LocalDate;
import java.util.Objects;

public record FNacimientoPaciente(LocalDate value)
{
	public FNacimientoPaciente
	{
		Objects.requireNonNull(value, "La fecha de nacimiento no puede ser nula");
		if (value.isAfter(LocalDate.now()))
		{
			throw new IllegalArgumentException("La fecha de nacimiento no puede ser futura");
		}
	}
}