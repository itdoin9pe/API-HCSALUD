package com.saludsystem.submodules.principal.model.dtos.command;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EstudioCreateCommand
{
	@Schema(description = "Descripción de estudios", example = "string")
	private String descripcion;
}