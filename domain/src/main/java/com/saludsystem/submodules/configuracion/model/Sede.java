package com.saludsystem.submodules.configuracion.model;

import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Sede
{
	private UUID id;
	private String codigo;
	private String nombre;
	private String direccion;
	private String ubigeo;
	private Integer estado;
	private UUID sucursalId;

	public Sede(UUID id, String codigo, String nombre, String direccion, String ubigeo, Integer estado, UUID sucursalId)
	{
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.ubigeo = ubigeo;
		this.estado = estado;
		this.sucursalId = sucursalId;
	}

	public void actualizarCodigo(String codigo)
	{
		if (codigo != null && !codigo.isBlank())
		{
			this.codigo = codigo;
		}
	}

	public void actualizarNombre(String nombre)
	{
		if (nombre != null && !nombre.isBlank())
		{
			this.nombre = nombre;
		}
	}

	public void actualizarDireccion(String direccion)
	{
		if (direccion != null && !direccion.isBlank())
		{
			this.direccion = direccion;
		}
	}

	public void actualizarUbigeo(String ubigeo)
	{
		if (ubigeo != null && !ubigeo.isBlank())
		{
			this.ubigeo = ubigeo;
		}
	}

	public void actualizarEstado(Integer estado)
	{
		if (estado != null)
		{
			this.estado = estado;
		}
	}

	public void actualizarSucursalId(UUID sucursalId)
	{
		if (sucursalId != null)
		{
			this.sucursalId = sucursalId;
		}
	}
}