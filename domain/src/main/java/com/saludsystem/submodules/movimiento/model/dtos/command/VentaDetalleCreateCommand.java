package com.saludsystem.submodules.movimiento.model.dtos.command;

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
public class VentaDetalleCreateCommand
{
	private UUID productoId;

	private UUID ventaId;

	private String codigoProducto;

	@Schema(example = "0")
	private Integer cantidad;

	@Schema(example = "0")
	private BigDecimal precioUnitario;

	@Schema(example = "0")
	private BigDecimal subtotal;
}