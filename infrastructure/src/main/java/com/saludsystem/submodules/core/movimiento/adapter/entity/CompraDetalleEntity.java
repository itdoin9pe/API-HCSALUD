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
@Table(name = "compra_detalle")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class CompraDetalleEntity extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "compraDetalle_id", nullable = false)
	private UUID compraDetalleId;

	@ManyToOne
	@JoinColumn(name = "compra_id", nullable = false)
	private CompraEntity compraEntity;

	@ManyToOne
	@JoinColumn(referencedColumnName = "producto_id", nullable = false)
	private ProductoEntity productoEntity;

	@Column(name = "cantidad_compras", nullable = false)
	private int cantidad;

	@Column(name = "precioUnitario", nullable = false)
	private BigDecimal precioUnitario;

	@Column(name = "igv_compraDetalle", nullable = false)
	private BigDecimal igv;

	@Column(name = "precioVenta_compraDetalle", nullable = false)
	private BigDecimal precioVenta;

	@Column(name = "subtotal_compraDetalle", nullable = false)
	private BigDecimal subtotal;
}