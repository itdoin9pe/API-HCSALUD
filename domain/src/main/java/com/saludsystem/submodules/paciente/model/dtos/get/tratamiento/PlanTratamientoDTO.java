package com.saludsystem.submodules.paciente.model.dtos.get.tratamiento;

import java.time.LocalDate;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlanTratamientoDTO
{
	private UUID pacientePlanTratamientoId;

	private UUID pacienteId;

	private UUID doctorId;

	private UUID especialidadId;

	private UUID medidaId;

	private LocalDate fechaInicio;

	private LocalDate fechaFin;
}