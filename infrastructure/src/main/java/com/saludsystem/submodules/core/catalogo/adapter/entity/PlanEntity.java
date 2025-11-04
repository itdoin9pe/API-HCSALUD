package com.saludsystem.submodules.core.catalogo.adapter.entity;

import java.time.LocalDate;
import java.util.UUID;

import com.saludsystem.submodules.core.configuracion.adapter.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "planes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PlanEntity extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id_plan", nullable = false, unique = true)
	private UUID planId;

	@Column(name = "nombre_plan", nullable = false, length = 100)
	private String nombrePlan;

	@Column(name = "fecha_inicio", nullable = false)
	private LocalDate fechaInicio;

	@Column(name = "fecha_fin_contrato", nullable = false)
	private LocalDate fechaFinContrato;

	@Column(name = "max_plan", nullable = false)
	private int maxPlan;

	@Column(name = "usu_max", nullable = false)
	private int usuMax;

	@Column(name = "costo_plan", nullable = false)
	private Double costoPlan;

	@Column(name = "estado", nullable = false)
	private Integer estado;
}