package com.saludsystem.submodules.catalogo.model;

import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TipoConcepto
{
	private UUID id;
	private String nombre;
	private Integer estado;

	public TipoConcepto(UUID id, String nombre, Integer estado)
	{
		this.id = id;
		this.nombre = nombre;
		this.estado = estado;
	}

	public void actualizarNombre(String nombre)
	{
		if (nombre != null && !nombre.isBlank())
		{
			this.nombre = nombre;
		}
	}

	public void actualizarEstado(Integer estado)
	{
		if (estado != null)
		{
			this.estado = estado;
		}
	}
}