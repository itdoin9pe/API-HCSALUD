package com.saludsystem.submodules.principal.model;

import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Aseguradora
{
	private UUID aseguradoraId;
	private String descripcion;
	private Integer estado;

	public Aseguradora(UUID aseguradoraId, String descripcion, Integer estado)
	{
		this.aseguradoraId = aseguradoraId;
		this.descripcion = descripcion;
		this.estado = estado;
	}
}