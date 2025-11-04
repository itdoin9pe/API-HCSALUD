package com.saludsystem.submodules.mantenimiento.model.dtos.command;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MonedaCreateCommand
{
	private String descripcion;

	@Schema(description = "Estado del tipo de moneda (0 = inactivo, 1 = activo)", example = "0")
	private Integer estado;
}