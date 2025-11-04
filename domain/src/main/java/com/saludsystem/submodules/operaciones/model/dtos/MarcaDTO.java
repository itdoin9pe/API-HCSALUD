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
public class MarcaDTO
{
	private UUID marcaId;

	private String nombre;

	@Schema(description = "Estado de marca", example = "0")
	private Integer estado;
}