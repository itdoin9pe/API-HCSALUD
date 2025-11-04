package com.saludsystem.submodules.movimiento.model.dtos;

import java.math.BigDecimal;
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
public class CompraDetalleDTO
{
	private UUID compraDetalleId;

	private UUID compraId;

	private UUID productoId;

	@Schema(example = "0")
	private int cantidad;

	@Schema(example = "0")
	private BigDecimal precioUnitario;

	@Schema(example = "0")
	private BigDecimal igv;

	@Schema(example = "0")
	private BigDecimal precioVenta;

	@Schema(example = "0")
	private BigDecimal subtotal;
}