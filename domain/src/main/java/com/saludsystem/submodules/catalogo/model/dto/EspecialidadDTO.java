package com.saludsystem.submodules.catalogo.model.dto;

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
public class EspecialidadDTO
{
	private UUID especialidadId;

	private String nombre;

	private String descripcion;

	@Schema(description = "Estado de Especialidades (0 = inactivo, 1 = activo)", example = "0")
	private Integer estado;
}