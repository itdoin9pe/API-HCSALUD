package com.saludsystem.submodules.core.movimiento.adapter.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import com.saludsystem.submodules.core.configuracion.adapter.entity.BaseEntity;
import com.saludsystem.submodules.core.operaciones.adapter.entity.CategoriaMatEntity;
import com.saludsystem.submodules.core.operaciones.adapter.entity.MarcaEntity;
import com.saludsystem.submodules.core.operaciones.adapter.entity.ProductoEntity;
import com.saludsystem.submodules.core.operaciones.adapter.entity.UnidadEntity;

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
@Table(name = "inventario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class InventarioEntity extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "inventario_id", nullable = false)
	private UUID inventarioId;

	@ManyToOne
	@JoinColumn(name = "almacen_id", nullable = true)
	private AlmacenEntity almacenEntity;

	@Column(name = "tipoDocumentoId", nullable = false)
	private int tipoInventarioId;

	@ManyToOne
	@JoinColumn(name = "producto_id", nullable = false)
	private ProductoEntity productoEntity;

	@ManyToOne
	@JoinColumn(name = "marcaMateriales_id", nullable = false)
	private MarcaEntity marcaMaterialEntity;

	@ManyToOne
	@JoinColumn(name = "categoriaMaterial_id", nullable = false)
	private CategoriaMatEntity categoriaMatEntity;

	@ManyToOne
	@JoinColumn(name = "unidad_id", nullable = false)
	private UnidadEntity unidadEntity;

	@Column(name = "precioEntrada_inventario", nullable = false)
	private BigDecimal precioEntrada;

	@Column(name = "precioSalida_inventario", nullable = false)
	private BigDecimal precioSalida;

	@Column(name = "stock_inventario", nullable = false)
	private Integer stock;

	@Column(name = "fecha_inventario", nullable = false)
	private LocalDate fecha;

	@Column(name = "estado_inventario", nullable = false)
	private Integer estado;
}