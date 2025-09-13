package com.saludsystem.submodules.mantenimiento.model.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EnfermedadDTO
{
	private String enfermedadId;

	private String descripcion;

	@Schema(description = "Estado de Diagnostico (0 = inactivo, 1 = activo)", example = "0")
	private Integer estado;
}