package com.saludsystem.submodules.mantenimiento.model.dtos;

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
public class TarifarioDTO
{
	private UUID tarifarioId;

	private UUID tipoConceptoId;

	private UUID medidaId;

	private UUID categoriaId;

	private UUID unidadId;

	private String grupo;

	private String descripcion;

	@Schema(description = "Precio del tarifario", example = "0")
	private Double precio;

	@Schema(description = "Estado del tarifario (0 = inactivo, 1 = activo)", example = "0")
	private Integer estado;
}