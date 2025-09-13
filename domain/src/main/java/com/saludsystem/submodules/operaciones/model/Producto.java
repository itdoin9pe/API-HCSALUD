package com.saludsystem.submodules.operaciones.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Producto
{
	// Identificadores
	private UUID id;
	private UUID marcaId;
	private UUID tipoMaterialId;
	private UUID unidadId;
	private UUID presentacionId;
	private UUID categoriaMatId;
	// Datos principales
	private String codigo;
	private String codigoBarras;
	private String nombre;
	private String descripcion;
	private String lote;
	private LocalDate fecha;
	// Inventario y precios
	private Integer stock;
	private BigDecimal precioCompra;
	private BigDecimal precioVenta;
	// Estados
	private String estadoVenta;
	private String estadoCompra;
	private Integer estadoProducto;

	public Producto(
		UUID id,
		UUID marcaId,
		UUID tipoMaterialId,
		UUID unidadId,
		UUID presentacionId,
		UUID categoriaMatId,
		String codigo,
		String codigoBarras,
		String nombre,
		String descripcion,
		BigDecimal precioCompra,
		BigDecimal precioVenta,
		Integer stock,
		String lote,
		LocalDate fecha,
		String estadoVenta,
		String estadoCompra,
		Integer estadoProducto)
	{
		this.id = id;
		this.marcaId = marcaId;
		this.tipoMaterialId = tipoMaterialId;
		this.unidadId = unidadId;
		this.presentacionId = presentacionId;
		this.categoriaMatId = categoriaMatId;
		this.codigo = codigo;
		this.codigoBarras = codigoBarras;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.stock = stock;
		this.lote = lote;
		this.fecha = fecha;
		this.estadoVenta = estadoVenta;
		this.estadoCompra = estadoCompra;
		this.estadoProducto = estadoProducto;
	}
}