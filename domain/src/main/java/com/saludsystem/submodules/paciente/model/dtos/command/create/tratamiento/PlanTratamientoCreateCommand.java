package com.saludsystem.submodules.paciente.model.dtos.command.create.tratamiento;

import java.time.LocalDate;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlanTratamientoCreateCommand
{
	private UUID pacienteId;
	private UUID doctorId;
	private UUID especialidadId;
	private UUID medidaId;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
}