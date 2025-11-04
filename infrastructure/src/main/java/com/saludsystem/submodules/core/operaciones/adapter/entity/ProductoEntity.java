package com.saludsystem.submodules.core.operaciones.adapter.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import com.saludsystem.submodules.core.configuracion.adapter.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Productos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class ProductoEntity extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "producto_id", nullable = false)
	private UUID productoId;

	@ManyToOne
	@JoinColumn(name = "marcaMateriales_id", nullable = false)
	private MarcaEntity marcaEntity;

	@ManyToOne
	@JoinColumn(name = "tipoMaterial_id", nullable = false)
	private TipoMaterialEntity tipoMaterialEntity;

	@ManyToOne
	@JoinColumn(name = "unidad_id", nullable = false)
	private UnidadEntity unidadEntity;

	@ManyToOne
	@JoinColumn(name = "presentacion_id", nullable = false)
	private PresentacionEntity presentacionEntity;

	@ManyToOne
	@JoinColumn(name = "categoriaMaterial_id", nullable = false)
	private CategoriaMatEntity categoriaMatEntity;

	@Column(name = "codigo_producto", nullable = false, unique = true)
	private String codigo;

	@Column(name = "nombre_producto", nullable = false, unique = true)
	private String nombre;

	@Column(name = "descripcion_producto", nullable = false)
	private String descripcion;

	@Column(name = "precioCompra_producto", nullable = false)
	private BigDecimal precioCompra;

	@Column(name = "precioVenta_producto", nullable = false)
	private BigDecimal precioVenta;

	@Column(name = "stock_producto", nullable = false)
	private Integer stock;

	@Column(name = "codBarras_producto", nullable = false, unique = true)
	private String codigoBarras;

	@Column(name = "lote_producto", nullable = false, unique = true)
	private String lote;

	@Column(name = "fecha_producto", nullable = false)
	private LocalDate fecha;

	@Column(name = "estadoVenta_producto", nullable = false)
	private String estadoVenta;

	@Column(name = "estadoCompra_producto", nullable = false)
	private String estadoCompra;

	@Column(name = "estado_producto", nullable = false)
	private Integer estadoProducto;
}