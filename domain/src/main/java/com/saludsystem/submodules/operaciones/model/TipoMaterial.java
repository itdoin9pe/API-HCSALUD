package com.saludsystem.submodules.operaciones.model;

import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TipoMaterial
{
	private UUID tipoMaterialId;
	private String nombre;
	private String descripcion;
	private Integer estado;

	public TipoMaterial(UUID tipoMaterialIUuid, String nombre, String descripcion, Integer estado)
	{
		this.tipoMaterialId = tipoMaterialIUuid;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
	}
}