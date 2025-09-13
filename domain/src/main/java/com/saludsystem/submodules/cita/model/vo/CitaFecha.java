package com.saludsystem.submodules.cita.model.vo;

import java.time.LocalDate;

public record CitaFecha(LocalDate value)
{
	public CitaFecha
	{
		if (value == null)
		{
			throw new IllegalArgumentException("La fecha de la cita no puede ser nula.");
		}
		if (value.isBefore(LocalDate.now()))
		{
			throw new IllegalArgumentException("La fecha de la cita no puede ser en el pasado.");
		}
	}
}
