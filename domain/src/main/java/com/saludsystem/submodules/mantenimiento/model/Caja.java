package com.saludsystem.submodules.mantenimiento.model;

import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Caja
{
	private UUID id;
	private String nombre;
	private Integer estado;

	public Caja(UUID id, String nombre, Integer estado)
	{
		this.id = id;
		this.nombre = nombre;
		this.estado = estado;
	}
}