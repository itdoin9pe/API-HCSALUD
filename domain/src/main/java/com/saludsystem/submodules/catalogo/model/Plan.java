package com.saludsystem.submodules.catalogo.model;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Plan
{
	private UUID id;
	private String nombrePlan;
	private LocalDate fechaInicio;
	private LocalDate fechaFinContrato;
	private int maxPlan;
	private int useMax;
	private Double costoPlan;
	private Integer estado;

	public Plan(
		UUID id,
		String nombrePlan,
		LocalDate fechaInicio,
		LocalDate fechaFinContrato,
		int maxPlan,
		int useMax,
		Double costoPlan,
		Integer estado)
	{
		this.id = id;
		this.nombrePlan = nombrePlan;
		this.fechaInicio = fechaInicio;
		this.fechaFinContrato = fechaFinContrato;
		this.maxPlan = maxPlan;
		this.useMax = useMax;
		this.costoPlan = costoPlan;
		this.estado = estado;
	}

	public void actualizarNombrePlan(String nombrePlan)
	{
		if (nombrePlan != null && !nombrePlan.isBlank())
		{
			this.nombrePlan = nombrePlan;
		}
	}

	public void actualizarFechaInicio(LocalDate fechaInicio)
	{
		if (fechaInicio != null)
		{
			this.fechaInicio = fechaInicio;
		}
	}

	public void actualizarFechaFin(LocalDate fechaFinContrato)
	{
		if (fechaFinContrato != null && (this.fechaInicio == null || !fechaFinContrato.isBefore(this.fechaInicio)))
		{
			this.fechaFinContrato = fechaFinContrato;
		}
	}

	public void actualizarMaxPlan(int maxPlan)
	{
		if (maxPlan >= 0)
		{
			this.maxPlan = maxPlan;
		}
	}

	public void actualizarUseMax(int useMax)
	{
		if (useMax >= 0)
		{
			this.useMax = useMax;
		}
	}

	public void actualizarCostoPlan(Double costoPlan)
	{
		if (costoPlan != null && costoPlan >= 0)
		{
			this.costoPlan = costoPlan;
		}
	}

	public void actualizarEstado(Integer estado)
	{
		if (estado != null)
		{
			this.estado = estado;
		}
	}
}