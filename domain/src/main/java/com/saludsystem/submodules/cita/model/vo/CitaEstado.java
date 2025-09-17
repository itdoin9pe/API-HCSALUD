package com.saludsystem.submodules.cita.model.vo;

import com.saludsystem.submodules.cita.model.enums.EstadoCitaEnum;

public record CitaEstado(EstadoCitaEnum value)
{
	public CitaEstado
	{
		if (value == null)
		{
			throw new IllegalArgumentException("El estado no puede ser nulo.");
		}
	}

	public boolean esCancelable()
	{
		return value == EstadoCitaEnum.ACTIVA || value == EstadoCitaEnum.CONFIRMADA;
	}

	public boolean esFinalizable()
	{
		return value == EstadoCitaEnum.CHECKED_IN;
	}
}
