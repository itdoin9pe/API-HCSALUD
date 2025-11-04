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
public class ConsentimientoDTO
{
	private UUID consentimientoId;

	private String nombre;

	private String observacion;

	private String texto;

	@Schema(description = "estado del consentimiento", example = "0")
	private Integer estado;
}