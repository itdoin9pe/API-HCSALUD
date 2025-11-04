package com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.estadocuenta;

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
@Table(name = "pacientes_estados_cuentas_pagos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class EPagoEntity extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id_pago", nullable = false)
	private UUID idPago;

	@ManyToOne
	@JoinColumn(name = "id_estado_cuenta", nullable = false)
	private EstadoCuentaEntity estadoCuentaEntity;

	@Column(name = "fecha_pago", nullable = false)
	private LocalDate fechaPago;

	@Column(name = "monto", nullable = false)
	private Double monto;

	@Column(name = "metodo_pago", nullable = false)
	private String metodoPago; // Ej: EFECTIVO, TARJETA, TRANSFERENCIA

	@Column(name = "referencia_pago")
	private String referenciaPago;
}