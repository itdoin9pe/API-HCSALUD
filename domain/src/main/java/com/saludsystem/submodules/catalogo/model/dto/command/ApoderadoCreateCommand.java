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
public class ApoderadoCreateCommand
{
	private String nombre;
	private String tipoDocumento;
	private String nroDocumento;
	private String direccion;
	private String telefono;
	@Schema(description = "Estado de Apoderado (0 = inactivo, 1 = activo)", example = "0")
	private Integer estado;
}