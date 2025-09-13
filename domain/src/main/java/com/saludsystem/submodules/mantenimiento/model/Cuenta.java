package com.saludsystem.submodules.mantenimiento.model;

import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Cuenta
{
	private UUID id;
	private String nombre;
	private Integer total;
	private Integer estado;

	public Cuenta(UUID cuentaPagarId, String nombre, Integer total, Integer estado)
	{
		this.id = cuentaPagarId;
		this.nombre = nombre;
		this.total = total;
		this.estado = estado;
	}
}