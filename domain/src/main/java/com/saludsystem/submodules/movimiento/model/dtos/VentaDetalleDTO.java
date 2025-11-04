package com.saludsystem.submodules.movimiento.model.dtos;

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
public class VentaDetalleDTO
{
	private UUID ventaDetalleId;

	private UUID productoId;

	private UUID ventaId;

	private String codigoProducto;

	@Schema(example = "0")
	private Integer cantidad;

	@Schema(example = "0")
	private Double precioUnitario;

	@Schema(example = "0")
	private Double subtotal;
}