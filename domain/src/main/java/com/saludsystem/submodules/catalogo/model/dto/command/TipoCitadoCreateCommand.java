package com.saludsystem.submodules.catalogo.model.dto.command;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TipoCitadoCreateCommand
{
	private String nombre;
	private String color;

	@Schema(description = "Estado del Tipo Citado (0 = inactivo, 1 = activo)", example = "0")
	private Integer estado;
}