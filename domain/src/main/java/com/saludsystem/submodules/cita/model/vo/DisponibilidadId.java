package com.saludsystem.submodules.cita.model.vo;

import java.util.UUID;

public record DisponibilidadId(UUID value)
{
	public DisponibilidadId
	{
		if (value == null)
		{
			throw new IllegalArgumentException("El id de la disponibilidad no puede ser nulo.");
		}
	}
}
