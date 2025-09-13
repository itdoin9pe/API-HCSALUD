package com.saludsystem.submodules.operaciones.model.dtos.command;

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
public class ProductoCreateCommand
{
	private UUID marcaMaterialesId;
	private UUID tipoMaterialId;
	private UUID unidadId;
	private UUID presentacionId;
	private UUID categoriaMaterialId;
	private String codigo;
	private String codigoBarras;
	private String nombre;
	private String descripcion;
	private String lote;

	@Schema(description = "Fecha de registro o caducidad del producto", example = "2025-04-03")
	private LocalDate fecha;

	@Schema(description = "Stock disponible del producto", example = "0")
	private Integer stock;

	@Schema(description = "Precio de compra del producto", example = "0.0")
	private BigDecimal precioCompra;

	@Schema(description = "Precio de venta del producto", example = "0.0")
	private BigDecimal precioVenta;
	// Estados
	@Schema(description = "Estado del Producto (ACTIVO = 1 / INACTIVO = 0)", example = "1")
	private Integer estadoProducto;

	@Schema(description = "Estado de la venta del producto (SI / NO)", example = "SI")
	private String estadoVenta;

	@Schema(description = "Estado de la compra del producto (SI / NO)", example = "NO")
	private String estadoCompra;
}