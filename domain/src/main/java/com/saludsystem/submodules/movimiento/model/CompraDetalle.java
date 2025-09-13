package com.saludsystem.submodules.movimiento.model;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CompraDetalle
{
	private UUID compraDetalleId;
	private UUID compraId;
	private UUID productoId;
	private Integer cantidad;
	private BigDecimal precioUnitario;
	private BigDecimal igv;
	private BigDecimal precioVenta;
	private BigDecimal subtotal;

	public CompraDetalle(
		UUID compraDetalleId,
		UUID compraId,
		UUID productoId,
		Integer cantidad,
		BigDecimal precioUnitario,
		BigDecimal igv,
		BigDecimal precioVenta,
		BigDecimal subtotal)
	{
		this.compraDetalleId = compraDetalleId;
		this.compraId = compraId;
		this.productoId = productoId;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.igv = igv;
		this.precioVenta = precioVenta;
		this.subtotal = subtotal;
	}
}