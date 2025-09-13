package com.saludsystem.submodules.configuracion.model.dtos.command;

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
public class SedeCreateCommand
{
	private String codigo;
	private String nombre;
	private String direccion;
	private String ubigeo;

	@Schema(description = "Estado de la sede (0 = inactivo, 1 = activo)", example = "0")
	private Integer estado;

	private UUID sucursalId;
}