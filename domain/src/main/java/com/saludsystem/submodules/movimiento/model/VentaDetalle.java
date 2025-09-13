package com.saludsystem.submodules.movimiento.model;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class VentaDetalle
{
	private UUID ventaDetalleId;
	private UUID productoId;
	private UUID ventaId;
	private String codigoProducto;
	private Integer cantidad;
	private BigDecimal precioUnitario;
	private BigDecimal subtotal;

	public VentaDetalle(
		UUID ventaDetalleId,
		UUID productoId,
		UUID ventaId,
		String codigoProducto,
		Integer cantidad,
		BigDecimal precioUnitario,
		BigDecimal subtotal)
	{
		this.ventaDetalleId = ventaDetalleId;
		this.productoId = productoId;
		this.ventaId = ventaId;
		this.codigoProducto = codigoProducto;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.subtotal = subtotal;
	}
}