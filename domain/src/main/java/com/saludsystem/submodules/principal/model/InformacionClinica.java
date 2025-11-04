package com.saludsystem.submodules.principal.model;

import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class InformacionClinica
{
	private UUID id;
	private String nombre;
	private Integer estado;

	public InformacionClinica(UUID id, String nombre, Integer estado)
	{
		this.id = id;
		this.nombre = nombre;
		this.estado = estado;
	}
}