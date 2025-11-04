package com.saludsystem.submodules.principal.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TipoPaciente
{
	private Long id;
	private String nombre;

	public TipoPaciente(Long id, String nombre)
	{
		this.id = id;
		this.nombre = nombre;
	}
}