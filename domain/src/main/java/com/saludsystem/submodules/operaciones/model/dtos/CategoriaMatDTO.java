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
public class CategoriaMatDTO
{
	private UUID categoriaMaterialId;

	private String nombre;

	private String descripcion;

	@Schema(description = "Estado de categorias materiales", example = "0")
	private Integer estado;
}