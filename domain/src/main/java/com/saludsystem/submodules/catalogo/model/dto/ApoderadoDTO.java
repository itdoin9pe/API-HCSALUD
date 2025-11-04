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
public class ApoderadoDTO
{
	private UUID apoderadoId;
	private String nombre;
	private String direccion;
	private String tipoDocumento;
	private String nroDocumento;
	private String telefono;

	@Schema(description = "Estado de Apoderado (0 = inactivo, 1 = activo)", example = "0")
	private Integer estado;
}