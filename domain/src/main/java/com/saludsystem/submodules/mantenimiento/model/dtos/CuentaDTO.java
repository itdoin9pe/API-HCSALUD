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
public class CuentaDTO
{
	private UUID cuentaPagarId;

	private String nombre;

	@Schema(description = "Total de cuentas a pagar", example = "0")
	private Integer total;

	@Schema(description = "Estado de cuentas a pagar (0 = inactivo, 1 = activo)", example = "0")
	private Integer estado;
}