package com.saludsystem.submodules.operaciones.model.dtos;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProveedorDTO
{
	private UUID proveedorId;

	private String ruc;

	@Schema(description = "qDhvZULMGjKAedzNwdna")
	private String nombre;

	private String direccion;

	private String telefono;

	@Schema(description = "user@example.com")
	private String correo;

	private String contacto;
}