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
public class TipoTarjetaDTO
{
	private UUID tipoTarjetaId;

	private String descripcion;

	@Schema(description = "Estado de Tipo de tarjeta (0 = inactivo, 1 = activo)", example = "0")
	private Integer estado;
}