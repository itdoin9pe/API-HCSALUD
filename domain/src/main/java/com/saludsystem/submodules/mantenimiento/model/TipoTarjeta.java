package com.saludsystem.submodules.mantenimiento.model;

import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TipoTarjeta
{
	private UUID tipoTarjetaId;
	private String descripcion;
	private Integer estado;

	public TipoTarjeta(UUID tipoTarjetaId, String descripcion, Integer estado)
	{
		this.tipoTarjetaId = tipoTarjetaId;
		this.descripcion = descripcion;
		this.estado = estado;
	}
}