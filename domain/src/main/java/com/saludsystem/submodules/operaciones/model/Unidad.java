package com.saludsystem.submodules.operaciones.model;

import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Unidad
{
	private UUID unidadId;
	private String nombre;
	private String siglas;
	private String descripcion;
	private Integer estado;

	public Unidad(UUID unidadId, String nombre, String siglas, String descripcion, Integer estado)
	{
		this.unidadId = unidadId;
		this.nombre = nombre;
		this.siglas = siglas;
		this.descripcion = descripcion;
		this.estado = estado;
	}
}