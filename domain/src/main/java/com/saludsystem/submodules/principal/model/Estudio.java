package com.saludsystem.submodules.principal.model;

import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Estudio
{
	private UUID id;
	private String descripcion;

	public Estudio(UUID id, String descripcion)
	{
		this.id = id;
		this.descripcion = descripcion;
	}
}