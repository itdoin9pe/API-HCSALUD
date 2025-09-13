package com.saludsystem.submodules.movimiento.model.dtos.command.edit;

import java.math.BigDecimal;
import java.util.UUID;

import com.saludsystem.submodules.BaseDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class CompraDetalleEditCommand extends BaseDTO
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