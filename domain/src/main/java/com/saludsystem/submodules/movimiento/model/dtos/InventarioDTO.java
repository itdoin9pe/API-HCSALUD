package com.saludsystem.submodules.movimiento.model.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;
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
public class InventarioDTO
{
	private UUID inventarioId;
	private UUID productoId;
	private UUID almacenId;

	@Schema(example = "0")
	private int tipoInventarioId;

	private UUID marcaMaterialId;
	private UUID categoriaMatId;
	private UUID unidadId;

	@Schema(example = "0")
	private BigDecimal precioEntrada;

	@Schema(example = "0")
	private BigDecimal precioSalida;

	@Schema(example = "0")
	private Integer stock;

	private LocalDate fecha;

	@Schema(example = "0")
	private Integer estado;
}