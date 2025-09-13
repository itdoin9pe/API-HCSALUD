package com.saludsystem.submodules.principal.model.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TipoPacienteDTO
{
	@Schema(description = "Estado del país (0 = inactivo, 1 = activo)", example = "1", type = "integer", defaultValue = "0")
	private Long tipoPacienteId;

	private String nombre;
}