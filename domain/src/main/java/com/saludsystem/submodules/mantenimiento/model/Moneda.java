package com.saludsystem.submodules.mantenimiento.model;

import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Moneda
{
	private UUID id;
	private String descripcion;
	private Integer estado;

	public Moneda(UUID uuid, String descripcion, Integer estado)
	{
		this.id = uuid;
		this.descripcion = descripcion;
		this.estado = estado;
	}
}