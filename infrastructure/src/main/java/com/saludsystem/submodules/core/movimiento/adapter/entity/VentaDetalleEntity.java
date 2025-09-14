package com.saludsystem.submodules.core.movimiento.adapter.entity;

import java.math.BigDecimal;
import java.util.UUID;

import com.saludsystem.submodules.core.configuracion.adapter.entity.BaseEntity;
import com.saludsystem.submodules.core.operaciones.adapter.entity.ProductoEntity;

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
@Table(name = "venta_detalle")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class VentaDetalleEntity extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "ventaDetalleId", nullable = false)
	private UUID ventaDetalleId;

	@ManyToOne
	@JoinColumn(name = "venta_id", nullable = false)
	private VentaEntity ventaEntity;

	@ManyToOne
	@JoinColumn(name = "producto_id", nullable = false)
	private ProductoEntity productoEntity;

	@Column(name = "codigo_producto", nullable = false)
	private String codigoProducto;

	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;

	@Column(name = "precio", precision = 10, scale = 2, nullable = false)
	private BigDecimal precio;

	@Column(name = "subtotal", precision = 10, scale = 2, nullable = false)
	private BigDecimal subtotal;
}