package com.saludsystem.submodules.catalogo.model;

import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Apoderado
{
	private UUID id;
	private String nombre;
	private String direccion;
	private String tipoDocumento;
	private String nroDocumento;
	private String telefono;
	private Integer estado;

	public Apoderado(
		UUID id,
		String nombre,
		String direccion,
		String tipoDocumento,
		String nroDocumento,
		String telefono,
		Integer estado)
	{
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.telefono = telefono;
		this.estado = estado;
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

	public void actualizarTipoDocumento(String tipoDocumento)
	{
		if (tipoDocumento != null && !tipoDocumento.isBlank())
		{
			this.tipoDocumento = tipoDocumento;
		}
	}

	public void actualizarNroDocumento(String nroDocumento)
	{
		if (nroDocumento != null && !nroDocumento.isBlank())
		{
			this.nroDocumento = nroDocumento;
		}
	}

	public void actualizarTelefono(String telefono)
	{
		if (telefono != null && !telefono.isBlank())
		{
			this.telefono = telefono;
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