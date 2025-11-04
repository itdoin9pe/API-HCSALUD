package com.saludsystem.submodules.cita.model.vo;

import java.time.LocalTime;

public record IntervaloTiempo(LocalTime inicio, LocalTime fin)
{
	public IntervaloTiempo
	{
		if (inicio == null || fin == null || !fin.isAfter(inicio))
		{
			throw new IllegalArgumentException("El intervalo de tiempo no es válido");
		}
	}

	public boolean seSuperpone(IntervaloTiempo otro)
	{
		return !otro.fin.isBefore(inicio) && !otro.inicio.isAfter(fin);
	}
}