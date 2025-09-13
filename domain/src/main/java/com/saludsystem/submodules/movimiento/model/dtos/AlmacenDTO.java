package com.saludsystem.submodules.movimiento.model.dtos;

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
public class AlmacenDTO
{
	private UUID almacenId;

	private String nombre;

	@Schema(description = "Estado de almacen", example = "0")
	private Integer estado;

	private UUID sedeId;

	private UUID sucursalId;
}