package com.saludsystem.submodules.operaciones.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class Producto {
	private UUID id;
	private UUID marcaId;
	private UUID tipoMaterialId;
	private UUID unidadId;
	private UUID presentacionId;
	private UUID categoriaMatId;
	private String codigo;
	private String nombre;
	private String descripcion;
	private BigDecimal precioCompra;
	private BigDecimal precioVenta;
	private Integer stock;
	private String lote;
	private LocalDate fecha;
	private String estadoVenta;
	private String estadoCompra;
	private Integer estadoProducto;

	public Producto(UUID id, UUID marcaId, UUID tipoMaterialId, UUID unidadId, UUID presentacionId, UUID categoriaMatId,
			String codigo, String nombre, String descripcion, BigDecimal precioCompra, BigDecimal precioVenta,
			Integer stock, String lote, LocalDate fecha, String estadoVenta, String estadoCompra,
			Integer estadoProducto) {
		this.id = id;
		this.marcaId = marcaId;
		this.tipoMaterialId = tipoMaterialId;
		this.unidadId = unidadId;
		this.presentacionId = presentacionId;
		this.categoriaMatId = categoriaMatId;
		this.codigo = codigo;
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