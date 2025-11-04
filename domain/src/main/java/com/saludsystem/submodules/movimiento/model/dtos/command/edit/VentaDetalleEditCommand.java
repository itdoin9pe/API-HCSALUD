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

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VentaDetalleEditCommand extends BaseDTO
{
	private UUID productoId;

	private UUID ventaId;

	private UUID ventaDetalleId;

	private String codigoProducto;

	@Schema(example = "0")
	private Integer cantidad;

	@Schema(example = "0")
	private BigDecimal precioUnitario;

	@Schema(example = "0")
	private BigDecimal subtotal;
}