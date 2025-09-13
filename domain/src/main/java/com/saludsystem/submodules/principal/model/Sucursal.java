package com.saludsystem.submodules.principal.model;

import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Sucursal
{
	private UUID sucursalId;
	private String nombre;
	private String direccion;
	private boolean isDefault;

	public Sucursal(UUID sucursalId, String nombre, String direccion, boolean isDefault)
	{
		this.sucursalId = sucursalId;
		this.nombre = nombre;
		this.direccion = direccion;
		this.isDefault = isDefault;
	}
}